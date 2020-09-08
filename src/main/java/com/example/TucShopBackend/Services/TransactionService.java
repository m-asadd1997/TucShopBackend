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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    UserDao userDao;
    @Autowired
    TransactionsRepository transactionsRepository;

    public ApiResponse saveTransactions(TransactionsDTO transactionsDTO,User user){


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
        String startDate= "1-"+  date.getMonth() + "-"+date.getYear();
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



}
