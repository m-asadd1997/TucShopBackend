package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.ProductTransaction;

import java.util.List;
import java.util.Map;

public class TransactionsDTO {

    Double amount;
    String action;
    String requestedUser;
    Double discount;


   List<ProductTransaction> productTransactions;


    public TransactionsDTO(Double amount, String action, String requestedUser, Double discount, List<ProductTransaction> productTransactions) {
        this.amount = amount;
        this.action = action;
        this.requestedUser = requestedUser;
        this.discount = discount;
        this.productTransactions = productTransactions;
    }

    public TransactionsDTO() {
    }


    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(String requestedUser) {
        this.requestedUser = requestedUser;
    }

    public List<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(List<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }
}
