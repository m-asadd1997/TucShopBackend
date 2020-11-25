package com.example.TucShopBackend.Models;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public String name;
    public String email;
    public String comment;
    public Integer noOfStars;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    public Review() {
    }

    public Review( String name, String email, String comment, Integer noOfStars, Product product) {

        this.name = name;
        this.email = email;
        this.comment = comment;
        this.noOfStars = noOfStars;
        this.product = product;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getNoOfStars() {
        return noOfStars;
    }

    public void setNoOfStars(Integer noOfStars) {
        this.noOfStars = noOfStars;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
