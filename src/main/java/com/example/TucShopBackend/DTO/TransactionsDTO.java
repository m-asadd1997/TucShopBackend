package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.ProductTransaction;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TransactionsDTO  implements Serializable {

    Double amount;
    String action;
    String requestedUser;
    Double totalAmount;
    LocalDate date;
    String createdBy;
    String updatedBy;
    String status;
    Double discount;
    String waiterName;
    Long tableNumber;
    Double profit;
    Double costprice;


   List<ProductTransaction> productTransactions;


    public TransactionsDTO(Double amount, Double costprice,  String action, String requestedUser, Double discount, List<ProductTransaction> productTransactions) {
        this.amount = amount;
        this.action = action;
        this.requestedUser = requestedUser;
        this.discount = discount;
        this.productTransactions = productTransactions;
        this.costprice = costprice;

    }

    public TransactionsDTO() {
    }

    public TransactionsDTO(Double amount, String action, String requestedUser, Double totalAmount, LocalDate date, String createdBy, String updatedBy, String status) {
        this.amount = amount;
        this.action = action;
        this.requestedUser = requestedUser;
        this.totalAmount = totalAmount;
        this.date = date;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.status = status;
        this.profit = profit;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }
}
