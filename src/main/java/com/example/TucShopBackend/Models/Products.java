package com.example.TucShopBackend.Models;
import lombok.Data;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Stream;


@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String image;
    String description;
    double price;
    double qty;
    double costprice;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @Column(name="products")
    private String products;

//    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
//    @JsonBackReference
//    public List<Transactions> transactions;
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<ProductTransaction> productTransactions;

    public Products() {
    }


    public Products(String products, ProductTransaction ... productTransactions) {
        this.products=products;
        for (ProductTransaction productTransaction :productTransactions) productTransaction.setProducts(this);
        this.productTransactions = Stream.of(productTransactions).collect(Collectors.toSet());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }


}
