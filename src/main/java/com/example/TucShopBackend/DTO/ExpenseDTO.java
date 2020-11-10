package com.example.TucShopBackend.DTO;


import com.example.TucShopBackend.Models.Expense_Details;

import java.time.LocalDate;
import java.util.List;

public class ExpenseDTO {
    Long id;
    Double total;
    LocalDate date;
    List<ExpenseDetailsDTO> expenseDetails;

    public ExpenseDTO() {
    }

    public ExpenseDTO(Long id, Double total, LocalDate date, List<ExpenseDetailsDTO> expenseDetails) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.expenseDetails = expenseDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ExpenseDetailsDTO> getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(List<ExpenseDetailsDTO> expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}