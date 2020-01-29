package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class CategoryDTO {
    String name;
    MultipartFile image;

    List<Products> productsList;

    public CategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
