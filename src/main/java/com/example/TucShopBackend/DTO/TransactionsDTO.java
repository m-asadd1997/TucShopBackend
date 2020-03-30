package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.ProductTransaction;

import java.util.List;
import java.util.Map;

public class TransactionsDTO {

    Double amount;


   List<ProductTransaction> productTransactions;

    public TransactionsDTO() {
    }



    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(List<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }
}
