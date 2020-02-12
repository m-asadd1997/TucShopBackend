package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/transaction")
public class TransactionsController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/post")
    public ApiResponse postTransaction(@RequestBody TransactionsDTO transactionsDTO){
        return transactionService.saveTransactions(transactionsDTO);
    }


    @GetMapping("/")
    public List<Transactions> getAll (TransactionsDTO transactionsDTO){
     return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Transactions getById (@PathVariable ("id") Long id){
        return this.transactionService.getById(id);
    }

}
