package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double amount;


    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<ProductCart> productCartSet = new HashSet<>();

    public Cart() {
    }

    public Cart(Long id, double amount, Set<ProductCart> productCartSet) {
        this.id = id;
        this.amount = amount;
        this.productCartSet = productCartSet;
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

    public Set<ProductCart> getProductCartSet() {
        return productCartSet;
    }

    public void setProductCartSet(Set<ProductCart> productCartSet) {
        this.productCartSet = productCartSet;
    }
}
