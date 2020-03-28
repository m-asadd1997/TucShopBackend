package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Product;

import java.util.Map;

public class TransactionsDTO {

    Double amount;


   // List<Product> products;
    Map<Product,Long> productWithQuantity;

    public TransactionsDTO() {
    }



    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Map<Product, Long> getProductWithQuantity() {
        return productWithQuantity;
    }

    public void setProductWithQuantity(Map<Product, Long> productWithQuantity) {
        this.productWithQuantity = productWithQuantity;
    }
}
