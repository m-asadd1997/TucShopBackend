package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class ProductsDTO {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank" )
    String name;
    @NotNull(message = "Image cannot be null")
    @NotBlank(message = "Image cannot be blank" )
    String image;
    String description;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price cannot be negative or 0")
    double price;
    Category category;

    public ProductsDTO() {
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
}
