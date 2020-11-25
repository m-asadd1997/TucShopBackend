package com.example.TucShopBackend.DTO;

public class OnlineProductDTO {
    Long id;
    String name;
    String image;
    double price;
    Long categoryId;

    public OnlineProductDTO() {
    }

    public OnlineProductDTO(Long id, String name, String image, double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
