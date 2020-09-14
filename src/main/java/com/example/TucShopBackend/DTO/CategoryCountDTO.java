package com.example.TucShopBackend.DTO;

public class CategoryCountDTO {


    String name;
    Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CategoryCountDTO(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
