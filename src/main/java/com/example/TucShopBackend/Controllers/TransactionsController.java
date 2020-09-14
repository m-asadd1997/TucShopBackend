package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Services.TransactionService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transaction;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/transaction")
public class TransactionsController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/post")
    public ApiResponse postTransaction(@RequestBody TransactionsDTO transactionsDTO, HttpServletRequest  request) throws FileNotFoundException, DocumentException {
        request.getAttribute("loggedinUser");
        User user = (User) request.getAttribute("loggedinUser");

        return transactionService.saveTransactions(transactionsDTO,user);
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
    @GetMapping("/recent-transactions")
    public List<Transactions> recentTransaction(){
        return this.transactionService.getRecentTransactions();
    }



    @GetMapping("/pending")
    public  List<Transactions> getAllPending (){
      return  this.transactionService.getAllPending();

    }

    @GetMapping("/closing/{user}")
    public ApiResponse onClosing(@PathVariable("user") String user){
        return transactionService.onClosing(user);
    }


    @GetMapping("/getRecentTransactionByUser/{user}")
    public List<Transactions> getRecentTransactionsByUser(@PathVariable("user")String user ){
        return transactionService.getRecentTransactionsByUser(user);
    }


    @GetMapping("/getTotalTransactionByUser/{user}")
    public ApiResponse totalTransaction(@PathVariable("user")String user ){
        return transactionService.getTotalTransactionByUser(user);
    }


}
