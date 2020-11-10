package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Expense;

public class ExpenseDetailsDTO {
    String subject;
    Double amount;
    Double debit;
    Double credit;
    Double balance;
    Expense expense;
    String type;

    public ExpenseDetailsDTO() {
    }

    public ExpenseDetailsDTO(String subject, Double amount, Double debit, Double credit, Double balance, Expense expense, String type) {
        this.subject = subject;
        this.amount = amount;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
        this.expense = expense;
        this.type = type;
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