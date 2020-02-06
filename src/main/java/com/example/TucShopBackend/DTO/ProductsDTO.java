package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProductsDTO {

    @NotNull(message = "Name not found")
    @Size(min = 3)
    String name;
    @NotNull(message = "Image not found")
    String image;
    @NotNull(message = "Description not found")
    @Size(min = 3)
    String description;
    @Positive(message = "Price cant be negative")
    double price;
    @NotNull(message = "Category not found")
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
