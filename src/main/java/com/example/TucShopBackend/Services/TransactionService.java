package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
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
        transactions.setCreatedBy(transactionsDTO.getCreatedBy());
        transactions.setDate(LocalDate.now());
        transactions.setProducts(transactionsDTO.getProducts());
        transactions.setUpdatedBy(transactionsDTO.getUpdatedBy());
        transactionsRepository.save(transactions);

        return new ApiResponse(200,"Transaction saved successfully",transactions);
    }


    public List<Transactions> getAll (){

        List<Transactions> transactionList =transactionsRepository.findAll();
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
}
