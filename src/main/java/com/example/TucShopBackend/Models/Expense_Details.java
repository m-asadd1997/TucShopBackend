package com.example.TucShopBackend.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Expense_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String subject;
    Double amount;
    Double debit;
    Double credit;
    Double balance;
    String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    Expense expense;

    public Expense_Details() {
    }

    public Expense_Details(String subject, Double debit, Double amount, Double credit, Double balance, String type, Expense expense) {
        this.subject = subject;
        this.debit = debit;
        this.amount = amount;
        this.credit = credit;
        this.balance = balance;
        this.type = type;
        this.expense = expense;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}