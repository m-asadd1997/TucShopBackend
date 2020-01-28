package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

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
}
