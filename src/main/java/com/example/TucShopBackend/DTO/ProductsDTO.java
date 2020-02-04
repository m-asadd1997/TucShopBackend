package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Category;
import org.springframework.web.multipart.MultipartFile;

public class ProductsDTO {
    String name;
    MultipartFile image;
    String description;
    double price;
    Category category;

    public ProductsDTO() {
    }

    public ProductsDTO(String name, MultipartFile image, String description, double price, Category category) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
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
