package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ScearchTransactionDTO;
import com.example.TucShopBackend.DTO.TransactionsDTO;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Services.TransactionService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    @GetMapping("/{startDate}/{endDate}")
    public List<TransactionsDTO> getAll (@PathVariable("startDate")String startDate, @PathVariable ("endDate") String endDate){
     return transactionService.getAll(startDate, endDate);
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
    @DeleteMapping("/deleteTransaction/{id}")
    public ApiResponse deleteTransaction(@PathVariable("id") Long id){
        return this.transactionService.deleteTransaction((id));

    }

    @GetMapping("/closing/{user}")
    public ResponseEntity<InputStreamResource> onClosing(@PathVariable("user") String user) throws IOException {
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

    @GetMapping("/getTotalTransaction/{startDate}/{endDate}")
    public ApiResponse getTotalTransactionByDate(@PathVariable("startDate")String startDate, @PathVariable ("endDate") String endDate ){
     return transactionService.getTotalTransactionByDate(startDate,endDate);

    }

    @PutMapping("/update/{id}")
    public ApiResponse updateTransaction(@PathVariable("id") Long id,@RequestBody TransactionsDTO transactionsDTO,HttpServletRequest  request) throws FileNotFoundException, DocumentException {
        request.getAttribute("loggedinUser");
        User user = (User) request.getAttribute("loggedinUser");
        return transactionService.updateTransaction(id,transactionsDTO,user);
    }

    @GetMapping("/downloadtransaction/{startDate}/{endDate}")
    public ResponseEntity<InputStreamResource> downloadAllTransaction(@PathVariable("startDate") String startDate, @PathVariable ("endDate") String endDate) throws IOException {
        return transactionService.downloadAllTransaction(startDate, endDate);
      
      
//    @DeleteMapping("/{id}")
//    public ApiResponse deleteTransaction(@PathVariable("id") Long id )  {
//        return transactionService.delete
//    }
    }

    @PostMapping("/onlinetransaction/{id}")
    public ApiResponse postOnlineTransaction (@PathVariable ("id")Long id, HttpServletRequest  request){
    request.getAttribute("loggedinUser");
    User user = (User) request.getAttribute("loggedinUser");
    return this.transactionService.postTransactionByOnlineOrderId(id, user);
    }

}





