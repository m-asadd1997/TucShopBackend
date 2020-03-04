package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Products;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TransactionsDTO {

    Double amount;

    List<Products> products;

    public TransactionsDTO() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
