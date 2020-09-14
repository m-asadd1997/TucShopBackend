package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.ProductTransaction;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class TransactionService {

    @Autowired
    UserDao userDao;
    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public ApiResponse saveTransactions(TransactionsDTO transactionsDTO,User user) throws FileNotFoundException, DocumentException {


        Transactions transactions = new Transactions();
        transactions.setAmount(transactionsDTO.getAmount());
        transactions.setCreatedBy(user.getName());
        transactions.setDate(LocalDate.now());
        transactions.setAction(transactionsDTO.getAction());
        if( transactionsDTO.getAction().equals("SC") ){
            transactions.setStatus("complete");
            transactions.setRequestedUser(user.getName());
        }else if(transactionsDTO.getAction().equals("ROD")){
            transactions.setStatus("pending");
            transactions.setRequestedUser(transactionsDTO.getRequestedUser());
        }


        Set<ProductTransaction> productTransactions = new HashSet<>();
        for(ProductTransaction productTransaction :transactionsDTO.getProductTransactions()){
            productTransactions.add(new ProductTransaction(productTransaction.getProduct(),transactions,productTransaction.getQuantity()));
        }

        transactions.setProductTransactions(productTransactions);
        //transactions.setProductTransactions(transactionsDTO.getProducts().stream().collect(Collectors.toSet())); // .setProducts(transactionsDTO.getProducts());
        transactions.setUpdatedBy(user.getName());


        transactionsRepository.save(transactions);

        return new ApiResponse(Status.Status_Ok,"Transaction saved successfully",transactions);
    }


    public List<Transactions>getAll (){

        LocalDate date1=LocalDate.now();
        String endDate=date1.toString();
        LocalDate date=LocalDate.now();
        String startDate= date.getYear()+"-"+date.getMonth()+"-1";
        List<Transactions> transactionList =transactionsRepository.getMonthTransactions(startDate,endDate);
        return transactionList;
    }

    public Transactions getById(Long id){
        Optional<Transactions> transactions=transactionsRepository.findById(id);

        if(transactions.isPresent()) {
            return transactions.get();
        }
        else {
            return new Transactions();
        }
    }

    public List<Transactions> getTransactionsByUser( String user){

        List<Transactions> transactionsList=transactionsRepository.findBycreatedBy(user);
        return transactionsList;
    }


    public List<Transactions> scearchTransactions(ScearchTransactionDTO scearchTransactionDTO){

        List<Transactions> transactionsList=transactionsRepository.scearchTransactionsOfUser(scearchTransactionDTO.getDateFrom(),scearchTransactionDTO.getDateTill(),scearchTransactionDTO.getUser());

                return transactionsList;


    }
    public List<Transactions> scearchAllTransactions(ScearchTransactionDTO scearchTransactionDTO){
        List<Transactions> transactionsList=transactionsRepository.getMonthTransactions(scearchTransactionDTO.getDateFrom(),scearchTransactionDTO.getDateTill());
        return transactionsList;

    }

    public List<Transactions> getRecentTransactions(){

        List<Transactions> transactionsList=transactionsRepository.recentTransactions();

        return transactionsList;


    }

    public List<Transactions>getRecentTransactionsByUser(String user){

      List<Transactions>transactionsListByUser=transactionsRepository.recentTransactionsOfUser(user);

      return  transactionsListByUser;

    }

    public ApiResponse getTotalTransactionByUser(String user) {
        return new ApiResponse(Status.Status_Ok, "Successfully fetch Total Transaction", transactionsRepository.totalTransactionsOfUser(user));
    }



    public List<Transactions>getAllPending(){

     List <Transactions> transactionsList=transactionsRepository.getAllPending();

     return transactionsList;

    }
    public ApiResponse deleteTransaction(Long id){
        Optional<Transactions> transactions=transactionsRepository.findById(id);


        if (transactions.isPresent()){
            transactions.get().setStatus("deleted");
            transactionsRepository.save(transactions.get());
            return new ApiResponse(200,"Successfully deleted",transactions.get());

        }
        else{
            return new ApiResponse(200,"not found",transactions.get());
        }

    }

    void sendMail(File file1) {

//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(recevierEmail);
//
//        msg.setSubject("Transaction Report");
//        msg.setText("Daily transaction report from tucshop application");
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
            helper.setTo("qureshiasad1000@gmail.com");
            helper.setSubject("Transaction Report");
            helper.setText("Daily transaction report from tucshop application");

            FileSystemResource file = new FileSystemResource(file1);
            helper.addAttachment("transactionReport.pdf", file);

            javaMailSender.send(message);
        }catch(MessagingException e){e.printStackTrace();}
    }

    public ApiResponse onClosing(String user){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        String productsName = "";
        List<Transactions> transactions = transactionsRepository.getTransactionsOnClosing(dtf.format(now),user);
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("TransactionReport.pdf"));
            PdfPTable table = new PdfPTable(5);
//            document.open();

            PdfPCell c1 = new PdfPCell(new Phrase("Transaction By"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Transaction Date"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Transaction Time"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Products"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Transaction Amount"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            table.setHeaderRows(1);

            document.open();
            document.addTitle("Transaction Report");
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            for(Transactions transaction : transactions) {
                for (ProductTransaction products : transaction.getProductTransactions()) {
                    productsName += products.getProduct().getName() + "(" + products.getQuantity() + ")" + ", ";
                }
//                Chunk chunk = new Chunk("Transaction by " + transaction.getCreatedBy() + "of products " + productsName + " of amount " + transaction.getAmount(), font);
                table.addCell(transaction.getCreatedBy());
                table.addCell(transaction.getDate().toString());
                table.addCell(transaction.getDate().toString());
                table.addCell(productsName);
                table.addCell(transaction.getAmount().toString());


            }
            document.add(table);
            document.close();
            sendMail(new File("TransactionReport.pdf"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ApiResponse(200,"closing successful",transactions);
    }



}
