package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.ProductCart;

import java.util.List;
import java.util.Set;

public class CartDTO {
    double amount;

    List<ProductCart> productCartList;

    public CartDTO() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ProductCart> getProductCartList() {
        return productCartList;
    }

    public void setProductCartList(List<ProductCart> productCartList) {
        this.productCartList = productCartList;
    }
}
