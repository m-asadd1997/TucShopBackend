package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate date;
    Double amount;
    String createdBy;
    String updatedBy;
    String requestedUser;
    String status;
    String action;
    String closingStatus;
    LocalTime transactionTime;
    Double discount;
    String waiterName;
    Long tableNumber;
    Double profit;


                       //request user
                       //status pending complete
                        //action rod, sc

//    @ManyToMany
//    @JoinTable(name = "Product_Transaction",joinColumns = @JoinColumn(name = "transaction_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id"))
//    public List<Product> products;


    @JsonManagedReference
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Set<ProductTransaction> productTransactions;

    public Transactions() {
    }

    public Transactions(Long id, Double profit, LocalDate date, Double amount, String createdBy, String updatedBy, String requestedUser, String status, String action, Double discount, Set<ProductTransaction> productTransactions) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.profit = profit;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.requestedUser = requestedUser;
        this.status = status;
        this.action = action;
        this.productTransactions = productTransactions;
    }

//    public Transactions(String name, ProductTransaction... productTransactions) {
//        this.name = name;
//        for(ProductTransaction pt : productTransactions) pt.setTransaction(this);
//        this.productTransactions = Stream.of(productTransactions).collect(Collectors.toSet());
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }


    public String getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(String requestedUser) {
        this.requestedUser = requestedUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }

    public String getClosingStatus() {
        return closingStatus;
    }

    public void setClosingStatus(String closingStatus) {
        this.closingStatus = closingStatus;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
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
}

