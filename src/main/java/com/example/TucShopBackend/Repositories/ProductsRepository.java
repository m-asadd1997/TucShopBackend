package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {


    @Query(value = "select * from products where category_id =:id ",nativeQuery = true)
    public List<Products> getAllByCategoryId(@Param("id") Long id);

    public Products findByName(String name);


    @Query(value = "select COUNT(id) from products", nativeQuery = true)
    public Long productQuantity();

    @Query(value = "select * from products where qty<10", nativeQuery = true)
    public List<Products> outOfStockProducts();

    @Query(value = "select COUNT(id) from products where qty<10",nativeQuery = true)
    public Long outOfStockCount();

    @Query(value ="SELECT * from products", nativeQuery = true)
    public List<Products> productQuantityDetails();
}
