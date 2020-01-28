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


}
