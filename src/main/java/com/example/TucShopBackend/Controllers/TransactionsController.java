package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.transaction.Transaction;
import java.io.IOException;
import java.util.List;

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


    @GetMapping("/")
    public List<Transactions> getAll (TransactionsDTO transactionsDTO){
     return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Transactions getById (@PathVariable ("id") Long id, @RequestBody  TransactionsDTO transactionsDTO){

        return this.transactionService.getById(id);


    }

//    public class EmailController {
//        @RequestMapping(value = "/sendemail")
//        public String sendEmail() throws IOException, MessagingException {
//            sendmail();
//            return "Email sent successfully";
//        }
}
