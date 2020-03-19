package com.example.TucShopBackend.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate date;
    Double amount;
    String createdBy;
    String updatedBy;
    //Double checkoutQuantity;





//    @ManyToMany
//    @JoinTable(name = "Product_Transaction",joinColumns = @JoinColumn(name = "transaction_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id"))


@OneToMany(mappedBy = "transactions", cascade = CascadeType.ALL)
private Set<ProductTransaction> productTransactions = new HashSet<>();

//    public List<Products> products;



    public Transactions() {
    }

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

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }



}

