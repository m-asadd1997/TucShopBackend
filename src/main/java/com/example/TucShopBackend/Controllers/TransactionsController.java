package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
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

    @GetMapping("/userTransaction/{user}")
    public List<Transactions> getUserTransactions(@PathVariable("user")String user ){
        return transactionService.getTransactionsByUser(user);

    }
    @PostMapping("/scearchTransactions")
    public List<Transactions> scearchTransactionsOfUser(@RequestBody ScearchTransactionDTO scearchTransactionDTO){
        return this.transactionService.scearchTransactions(scearchTransactionDTO);
    }

    @PostMapping("/scearchAllTransaction")
    public List<Transactions> scearchAllTransactions(@RequestBody ScearchTransactionDTO scearchTransactionDTO){
        return this.transactionService.scearchAllTransactions(scearchTransactionDTO);
    }

}
