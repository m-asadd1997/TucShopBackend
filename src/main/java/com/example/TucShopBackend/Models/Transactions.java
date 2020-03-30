package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
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


//    @ManyToMany
//    @JoinTable(name = "Product_Transaction",joinColumns = @JoinColumn(name = "transaction_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id"))
//    public List<Product> products;
    @JsonIgnore
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Set<ProductTransaction> productTransactions;

    public Transactions() {
    }

    public Transactions(LocalDate date, Double amount, String createdBy, String updatedBy, Set<ProductTransaction> productTransactions) {
        this.date = date;
        this.amount = amount;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
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

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }
}

