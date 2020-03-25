package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Category;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UpdateStockDTO {

//    String name;
//    String description;
//    double price;
//    Category category;
    double quantity;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int count;
//    Double costprice;




//
    public UpdateStockDTO(  ){
//        this.name = name;

//        this.description = description;

//        this.price = price;

//        this.category = category;
//        this.costprice=costprice;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
//
//    public Double getCostprice() {
//        return costprice;
//    }
//
//    public void setCostprice(Double costprice) {
//        this.costprice = costprice;
//    }
}
