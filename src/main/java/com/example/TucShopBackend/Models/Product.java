package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String image;
    String description;
    double price;
    double qty;
    double costprice;
    String variants;
    boolean active;
    boolean infiniteQuantity;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String  date1) {

        this.date1 = date1;
    }

   
    String date1;

   // @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

//    @ManyToMany(mappedBy = "products")
//    @JsonBackReference
//    public List<Transactions> transactions;
    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductTransaction> productTransactions = new HashSet<>();


    public Product() {
    }

    public Product(Long id, String name, String image, String description, double price, double qty, double costprice, String variants, boolean active, boolean infiniteQuantity, String date1, Category category, Set<ProductTransaction> productTransactions) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.costprice = costprice;
        this.variants = variants;
        this.active = active;
        this.infiniteQuantity = infiniteQuantity;
        this.date1 = date1;
        this.category = category;
        this.productTransactions = productTransactions;
    }

    //    public Product(Long id, String name, String image, String description, double price, double qty, double costprice, String variants, Category category, List<Transactions> transactions) {
//        this.id = id;
//        this.name = name;
//        this.image = image;
//        this.description = description;
//        this.price = price;
//        this.qty = qty;
//        this.costprice = costprice;
//        this.variants = variants;
//        this.category = category;
//        this.transactions = transactions;
//    }


    public boolean isActive() {
        return active;
    }

    public boolean isInfiniteQuantity() {
        return infiniteQuantity;
    }

    public void setInfiniteQuantity(boolean infiniteQuantity) {
        this.infiniteQuantity = infiniteQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVariants() {
        return variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }
}
