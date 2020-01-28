package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Products;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TransactionsDTO {
    LocalDate date;
    Double amount;
    String createdBy;
    String updatedBy;
    List<Products> products;

    public TransactionsDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
