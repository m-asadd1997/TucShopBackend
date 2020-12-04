package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    double amount;


    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<ProductCart> products = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private Online_Order onlineOrder;


    public Cart() {
    }

    public Cart(Long id, double amount, Set<ProductCart> productCartSet, Online_Order onlineOrder) {
        this.id = id;
        this.amount = amount;
        this.products = productCartSet;
        this.onlineOrder = onlineOrder;
    }

    public Cart(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<ProductCart> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductCart> products) {
        this.products = products;
    }

    public Online_Order getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(Online_Order onlineOrder) {
        this.onlineOrder = onlineOrder;
    }
}
