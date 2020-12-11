package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.Config.PdfUtil;
import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.*;
import com.example.TucShopBackend.Repositories.OnlineOrderRepository;
import com.example.TucShopBackend.Repositories.SettingsRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Autowired
    SettingsRepository settingsRepository;

    @Autowired
    OnlineOrderRepository onlineOrderRepository;

    @Autowired
    PdfUtil pdfUtil;

    public ApiResponse saveTransactions(TransactionsDTO transactionsDTO, User user) throws FileNotFoundException, DocumentException {

        Double amount = 0D;
        Double discount = 0D;
        Double costPrice = 0D;
        Double totalProfit = 0D;


        Transactions transactions = new Transactions();
        transactions.setAmount(transactionsDTO.getAmount());
        transactions.setCreatedBy(user.getName());
        transactions.setDate(LocalDate.now());
        transactions.setDiscount(transactionsDTO.getDiscount());
        transactions.setTransactionTime(LocalTime.now());
        transactions.setAction(transactionsDTO.getAction());
        transactions.setClosingStatus("OPEN");
        transactions.setDiscount(transactionsDTO.getDiscount());
        amount = transactions.getAmount();
        discount = transactionsDTO.getDiscount();
        costPrice = transactionsDTO.getCostprice();
        totalProfit = amount - costPrice - discount;
        transactions.setProfit(totalProfit);
        transactions.setWaiterName(transactionsDTO.getWaiterName());
        transactions.setTableNumber(transactionsDTO.getTableNumber());
        if (transactionsDTO.getAction().equals("SC")) {
            transactions.setStatus("complete");
            transactions.setRequestedUser(user.getName());
        } else if (transactionsDTO.getAction().equals("ROD")) {
            transactions.setStatus("pending");
            transactions.setRequestedUser(transactionsDTO.getRequestedUser());
        }


        Set<ProductTransaction> productTransactions = new HashSet<>();
        for (ProductTransaction productTransaction : transactionsDTO.getProductTransactions()) {
            productTransactions.add(new ProductTransaction(productTransaction.getProduct(), transactions, productTransaction.getQuantity()));
        }
        transactions.setProductTransactions(productTransactions);
        //transactions.setProductTransactions(transactionsDTO.getProducts().stream().collect(Collectors.toSet())); // .setProducts(transactionsDTO.getProducts());
        transactions.setUpdatedBy(user.getName());


        transactionsRepository.save(transactions);

        return new ApiResponse(Status.Status_Ok, "Transaction saved successfully", transactions);
    }


    public List<TransactionsDTO> getAll(String startDate, String endDate) {

        List<TransactionsDTO> transactionList = transactionsRepository.getTotalTransactionByDate(startDate, endDate);
        return transactionList;
    }

    public Transactions getById(Long id) {
        Optional<Transactions> transactions = transactionsRepository.findById(id);

        if (transactions.isPresent()) {
            return transactions.get();
        } else {
            return new Transactions();
        }
    }

    public List<Transactions> getTransactionsByUser(String user) {

        List<Transactions> transactionsList = transactionsRepository.findBycreatedBy(user);
        return transactionsList;
    }


    public List<Transactions> scearchTransactions(ScearchTransactionDTO scearchTransactionDTO) {

        List<Transactions> transactionsList = transactionsRepository.scearchTransactionsOfUser(scearchTransactionDTO.getDateFrom(), scearchTransactionDTO.getDateTill(), scearchTransactionDTO.getUser());

        return transactionsList;


    }

    public List<Transactions> scearchAllTransactions(ScearchTransactionDTO scearchTransactionDTO) {
        List<Transactions> transactionsList = transactionsRepository.getMonthTransactions(scearchTransactionDTO.getDateFrom(), scearchTransactionDTO.getDateTill());
        return transactionsList;

    }

    public List<Transactions> getRecentTransactions() {

        List<Transactions> transactionsList = transactionsRepository.recentTransactions();

        return transactionsList;


    }

    public List<Transactions> getRecentTransactionsByUser(String user) {

        List<Transactions> transactionsListByUser = transactionsRepository.recentTransactionsOfUser(user);

        return transactionsListByUser;

    }

    public ApiResponse getTotalTransactionByUser(String user) {
        return new ApiResponse(Status.Status_Ok, "Successfully fetch Total Transaction", transactionsRepository.totalTransactionsOfUser(user));
    }


    public List<Transactions> getAllPending() {

        List<Transactions> transactionsList = transactionsRepository.getAllPending();

        return transactionsList;


    }

    public ApiResponse deleteTransaction(Long id) {
        Optional<Transactions> transactions = transactionsRepository.findById(id);


        if (transactions.isPresent()) {
            try {
                transactionsRepository.deleteById(id);
                return new ApiResponse(200, "Successfully deleted", transactions.get());
            } catch (Exception e) {
                return new ApiResponse(200, "not found", transactions.get());
            }

        }else{
            return new ApiResponse(200, "not found", transactions.get());
        }

    }


        void sendMail (File file1){

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
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        public ResponseEntity<InputStreamResource> onClosing (String user) throws IOException {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String todayDate = LocalDate.now().toString();
            List<Settings> settings = settingsRepository.findAll();
            String header;
            Integer srno = 1;
            if (!settings.isEmpty()) {
                header = settings.get(0).getHeader();
            } else {
                header = "Today Date:" + todayDate;
            }

            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            StringBuilder productsName = null;
            Double total = 0D;
            Double discount = 0D;
            Double totalAfterDiscount = 0D;
            Double totalProfit = 0D;

            List<Transactions> transactions = transactionsRepository.getTransactionsOnClosing(user);
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("TransactionReport.pdf"));

                Font fontHeader = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                Paragraph headingPara, totalPara, profitPara, discountPara, totalDiscountPara;
                headingPara = new Paragraph(header + "\n" + "\n");
                headingPara.setAlignment(Element.ALIGN_CENTER);

//            Chunk chunk = new Chunk(header, fontHeader);

//            Chunk newLine = new Chunk("\n");

                PdfPTable table = new PdfPTable(8);
                table.setWidths(new float[]{2f, 5f, 5f, 5f, 9f, 5f, 4f, 4f});
//            document.open();

                PdfPCell c1 = new PdfPCell(new Phrase("SR#"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Transaction By"));
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

                c1 = new PdfPCell(new Phrase("Discount"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Profit"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);


                table.setHeaderRows(1);
//            table.setFooterRows(1);

                document.open();
                document.addTitle("Transaction Report");
                document.add(headingPara);

                Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                for (Transactions transaction : transactions) {

                    transaction.setClosingStatus("CLOSED");
                    total += transaction.getAmount();
                    discount += transaction.getDiscount();
                    totalAfterDiscount = total - discount;
                    totalProfit += transaction.getProfit();
                    transactionsRepository.save(transaction);
                    productsName = new StringBuilder();
                    for (ProductTransaction products : transaction.getProductTransactions()) {
                        productsName.append(products.getProduct().getName());
                        productsName.append("(");
                        productsName.append(products.getQuantity());
                        productsName.append(")");
                        productsName.append(",");

                    }
//                Chunk chunk = new Chunk("Transaction by " + transaction.getCreatedBy() + "of products " + productsName + " of amount " + transaction.getAmount(), font);
                    table.addCell(srno.toString());
                    table.addCell(transaction.getCreatedBy());
                    table.addCell(transaction.getDate().toString());
                    table.addCell(transaction.getTransactionTime().toString());
                    table.addCell(productsName.toString());
                    table.addCell(transaction.getAmount().toString());
                    table.addCell(transaction.getDiscount().toString());
                    table.addCell(transaction.getProfit().toString());
                    // table.
                    srno++;


                }
                totalPara = new Paragraph("\n" + "Total Amount : " + total);
                totalPara.setAlignment(Element.ALIGN_RIGHT);
                profitPara = new Paragraph("\n" + "Profit : " + totalProfit);
                profitPara.setAlignment(Element.ALIGN_RIGHT);
                discountPara = new Paragraph("\n" + "Discount Amount : " + discount);
                discountPara.setAlignment(Element.ALIGN_RIGHT);
                totalDiscountPara = new Paragraph("\n" + "Total Amount after Discount : " + totalAfterDiscount);
                totalDiscountPara.setAlignment(Element.ALIGN_RIGHT);
                table.setWidthPercentage(100);
                document.add(table);
                document.add(totalPara);
                document.add(profitPara);
                document.add(discountPara);
                document.add(totalDiscountPara);

//            document.add
                document.close();
                try {
                    sendMail(new File("TransactionReport.pdf"));
                } catch (Exception mail) {
                    mail.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            File f = new File("TransactionReport.pdf");
            Resource file = new UrlResource(f.toURI());
            return ResponseEntity
                    .ok()
                    .contentLength(file.contentLength())
                    .contentType(
                            MediaType.parseMediaType("application/pdf"))
                    .body(new InputStreamResource(file.getInputStream()));

//        return new ApiResponse(200,"closing successful",transactions);


        }

        public ApiResponse getTotalTransactionByDate (String startDate, String endDate){

            return new ApiResponse(Status.Status_Ok, "Successfully fetch Total Transaction", transactionsRepository.getTotalTransactionByDate(startDate, endDate));

        }

        public ApiResponse updateTransaction (Long id, TransactionsDTO transactionsDTO, User user) throws
        FileNotFoundException, DocumentException {

            Transactions transaction = transactionsRepository.findById(id).get();
            transactionsRepository.delete(transaction);

            return saveTransactions(transactionsDTO, user);

        }


        public ResponseEntity<InputStreamResource> downloadAllTransaction (String startDate, String endDate) throws  IOException {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String todayDate = LocalDate.now().toString();
            List<Settings> settings = settingsRepository.findAll();
            String header;
            Integer srno = 1;
            if (!settings.isEmpty()) {
                header = settings.get(0).getHeader();
            } else {
                header = "Today Date:" + todayDate;
            }


            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            StringBuilder productsName = null;
            Double total = 0D;
            Double discount = 0D;
            Double totalAfterDiscount = 0D;
            Double totalProfit = 0D;


            List<Transactions> transactions = transactionsRepository.downloadTransactionByDate(startDate, endDate);
            if (!transactions.isEmpty()) {
                try {
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream("TransactionReport.pdf"));

                    Font fontHeader = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    Paragraph headingPara, totalPara, profitPara, discountPara, totalDiscountPara;
                    headingPara = new Paragraph(header + "\n" + "\n");
                    headingPara.setAlignment(Element.ALIGN_CENTER);

//            Chunk chunk = new Chunk(header, fontHeader);

//            Chunk newLine = new Chunk("\n");

                    PdfPTable table = new PdfPTable(8);
                    table.setWidths(new float[]{2f, 5f, 5f, 5f, 9f, 5f, 4f, 4f});

//            document.open();

                    PdfPCell c1 = new PdfPCell(new Phrase("SR#"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    c1 = new PdfPCell(new Phrase("Transaction By"));
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

                    c1 = new PdfPCell(new Phrase("Discount"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    c1 = new PdfPCell(new Phrase("Profit"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);


                    table.setHeaderRows(1);
//            table.setFooterRows(1);

                    document.open();
                    document.addTitle("Transaction Report");
                    document.add(headingPara);

                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    for (Transactions transaction : transactions) {

                        // transaction.setClosingStatus("CLOSED");
                        total += transaction.getAmount();
                        discount += transaction.getDiscount();
                        totalAfterDiscount = total - discount;
                        totalProfit += transaction.getProfit();
                        // transactionsRepository.save(transaction);
                        productsName = new StringBuilder();
                        for (ProductTransaction products : transaction.getProductTransactions()) {
                            productsName.append(products.getProduct().getName());
                            productsName.append("(");
                            productsName.append(products.getQuantity());
                            productsName.append(")");
                            productsName.append(",");

                        }
//                Chunk chunk = new Chunk("Transaction by " + transaction.getCreatedBy() + "of products " + productsName + " of amount " + transaction.getAmount(), font);
                        table.addCell(srno.toString());
                        table.addCell(transaction.getCreatedBy());
                        table.addCell(transaction.getDate().toString());
                        table.addCell(transaction.getTransactionTime().toString());
                        table.addCell(productsName.toString());
                        table.addCell(transaction.getAmount().toString());
                        table.addCell(transaction.getDiscount().toString());
                        table.addCell(transaction.getProfit().toString());
                        // table.
                        srno++;


                    }
                    totalPara = new Paragraph("\n" + "Total Amount : " + total);
                    totalPara.setAlignment(Element.ALIGN_RIGHT);
                    profitPara = new Paragraph("\n" + "Profit : " + totalProfit);
                    profitPara.setAlignment(Element.ALIGN_RIGHT);
                    discountPara = new Paragraph("\n" + "Discount Amount : " + discount);
                    discountPara.setAlignment(Element.ALIGN_RIGHT);
                    totalDiscountPara = new Paragraph("\n" + "Total Amount after Discount : " + totalAfterDiscount);
                    totalDiscountPara.setAlignment(Element.ALIGN_RIGHT);
                    table.setWidthPercentage(100);
                    document.add(table);
                    document.add(totalPara);
                    document.add(profitPara);
                    document.add(discountPara);
                    document.add(totalDiscountPara);

//            document.add
                    document.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return null;

            }
            File f = new File("TransactionReport.pdf");
            Resource file = new UrlResource(f.toURI());
            return ResponseEntity
                    .ok()
                    .contentLength(file.contentLength())
                    .contentType(
                            MediaType.parseMediaType("application/pdf"))
                    .body(new InputStreamResource(file.getInputStream()));
        }



      public  ApiResponse postTransactionByOnlineOrderId(Long id, User user){
      Online_Order onlineOrder = onlineOrderRepository.findById(id).get();
            Transactions transactions = new Transactions();
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            transactions.setAmount(onlineOrder.getOrderTotal());
            transactions.setCreatedBy(onlineOrder.getEmailAddress());
            transactions.setRequestedUser(onlineOrder.getFirstName()+" "+onlineOrder.getLastName());
            transactions.setUpdatedBy(user.getName());
            transactions.setStatus("Complete");
            transactions.setClosingStatus("OPEN");
            transactions.setTableNumber(null);
            transactions.setWaiterName(null);
            transactions.setAction("SC");
            transactions.setDate(localDate);
            transactions.setTransactionTime(localTime);

         return new ApiResponse(Status.Status_Ok, "Order Completed! Online Transaction Successfully Saved", transactionsRepository.save(transactions));

    }

}





