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

    @Query(value = "select * from products where name =:name",nativeQuery = true)
    public String getAllByCategoryName(@Param("name") String name);

    @Query(value = "select COUNT(id) from products",nativeQuery = true)
    public Long getAllProductCount();

    @Query(value = "select SUM(price) from products",nativeQuery = true)
    public double getAllProductPriceSum();

    @Query(value = "select * from products ",nativeQuery = true)
    public List<Products> getAllProductPriceSumDetails();
}
