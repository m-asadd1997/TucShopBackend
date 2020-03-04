package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionsRepository transactionsRepository;

    public ApiResponse saveTransactions(TransactionsDTO transactionsDTO){
        Transactions transactions = new Transactions();
        transactions.setAmount(transactionsDTO.getAmount());
        transactions.setCreatedBy("ADMIN");
        transactions.setDate(LocalDate.now());
        transactions.setProducts(transactionsDTO.getProducts());
        transactions.setUpdatedBy("ADMIN");
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



}
