package com.example.TucShopBackend.DTO;

import com.example.TucShopBackend.Models.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class ProductsDTO {


    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank" )
  @Size(min = 3)
    String name;
    //    @NotNull(message = "Image cannot be null")
    //    @NotBlank(message = "Image cannot be blank" )
    MultipartFile image;
  @NotNull(message = "Description not found")
    @Size(min = 3)
    String description;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price cannot be negative or 0")
    double price;
    @NotNull(message = "Category not found")
    Category category;
    Double quantity;
    Double costprice;
    String variants;
    boolean active;
    String sku;
    String onlineProduct;
    List<MultipartFile> productImages;

    public String  getDate1() {


        SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd");
        myDate.setTimeZone(TimeZone.getTimeZone("PKT"));
        java.util.Date datee =new java.util.Date();

        date1= myDate.format(datee);
        return date1;
    }

    public void setDate1(String  date1) {

        this.date1=date1;
    }


    public String date1;


    public ProductsDTO() {
    }

    public ProductsDTO(@NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be blank") @Size(min = 3) String name, MultipartFile image, @NotNull(message = "Description not found") @Size(min = 3) String description, @NotNull(message = "Price cannot be null") @Positive(message = "Price cannot be negative or 0") double price, @NotNull(message = "Category not found") Category category, Double quantity, Double costprice, String variants, boolean active, String sku, String date1) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.costprice = costprice;
        this.variants = variants;
        this.active = active;
        this.sku = sku;
        this.date1 = date1;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
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

    public String getVariants() {
        return variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getOnlineProduct() {
        return onlineProduct;
    }

    public void setOnlineProduct(String onlineProduct) {
        this.onlineProduct = onlineProduct;
    }

    public List<MultipartFile> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }
}
