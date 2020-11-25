package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Product;

import java.util.List;

public class ReviewDTO {

    public String name;
    public String email;
    public String comment;
    public Integer noOfStars;
    public Product product;

    public ReviewDTO() {
    }

    public ReviewDTO(String name, String email, String comment, Integer noOfStars) {
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.noOfStars = noOfStars;
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
