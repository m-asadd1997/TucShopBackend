package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Products;

import java.util.List;

public class CategoryDTO {
    String name;
    String image;

    List<Products> productsList;

    public CategoryDTO() {
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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
