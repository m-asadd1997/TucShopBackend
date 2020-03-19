package com.example.TucShopBackend.Models;
import org.hibernate.annotations.GeneratorType;
import javax.persistence.Id;
import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name="product_transaction")
public class ProductTransaction implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    @Id
    @ManyToOne
    @JoinColumn(name = "transactions_id")
    private  Transactions transactions;



    @Column
    private Double quantity;

    public ProductTransaction() {

    }

    public ProductTransaction(Products transactions, Double quantity) {
        this.products = transactions;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTransaction that = (ProductTransaction) o;
        return Objects.equals(products, that.products) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, quantity);
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
