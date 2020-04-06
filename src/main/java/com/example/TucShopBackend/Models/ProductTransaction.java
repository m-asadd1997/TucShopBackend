package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity()
@Table(name="product_transaction")

public class ProductTransaction implements Serializable {

    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn()
    private Transactions transaction;

    @Id
    @ManyToOne
    @JoinColumn
    private Product product;

    private Long quantity;

    public ProductTransaction() {

    }

    public ProductTransaction(Product product, Transactions transactions, Long quantity) {
        this.product = product;
        this.transaction = transactions;
        this.quantity = quantity;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductTransaction that = (ProductTransaction) o;

        if (transaction != null ? !transaction.equals(that.transaction) : that.transaction != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return quantity != null ? quantity.equals(that.quantity) : that.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = transaction != null ? transaction.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
