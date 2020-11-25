package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="product_cart")
public class ProductCart implements Serializable {

    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn()
    private Product product;

    private Double quantity;

    public ProductCart() {
    }

    public ProductCart(Cart cart, Product product, double quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCart that = (ProductCart) o;

        if (cart != null ? !cart.equals(that.cart) : that.cart != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return quantity != null ? quantity.equals(that.quantity) : that.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = cart != null ? cart.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
