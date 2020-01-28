package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/transaction")
public class TransactionsController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/")
    public ApiResponse postTransaction(@RequestBody TransactionsDTO transactionsDTO){
        return transactionService.saveTransactions(transactionsDTO);
    }
}
