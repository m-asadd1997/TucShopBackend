package com.example.TucShopBackend.Controllers;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ExpenseDTO;
import com.example.TucShopBackend.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/post")
    public ApiResponse postExpense(@RequestBody ExpenseDTO expenseDTO){
        return expenseService.postExpense(expenseDTO);
    }

    @GetMapping("/{date}")
    public ApiResponse getExpenseByDate(@PathVariable String date){
        return expenseService.getExpenseByDate(date);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDTO expenseDTO){
        return expenseService.updateExpense(id,expenseDTO);
    }

}