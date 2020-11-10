package com.example.TucShopBackend.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double total;
    LocalDate date;
    @OneToMany(mappedBy = "expense",cascade = CascadeType.ALL)
    List<Expense_Details> expenseDetailsList;

    public Expense() {
    }

    public Expense(Long id, Double total, LocalDate date, List<Expense_Details> expenseDetailsList) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.expenseDetailsList = expenseDetailsList;
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

    public List<Expense_Details> getExpenseDetailsList() {
        return expenseDetailsList;
    }

    public void setExpenseDetailsList(List<Expense_Details> expenseDetailsList) {
        this.expenseDetailsList = expenseDetailsList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}