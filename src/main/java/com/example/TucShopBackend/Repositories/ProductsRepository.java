package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Models.TotalProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "select id ,date1 from products",nativeQuery = true)
        public List<Object>  productQauntity();

    @Query(value = "select * from products", nativeQuery = true)
    public List<Products> productQauntityDetails();

//    @Query(value = "select * from products ",nativeQuery = true)
//    public List<Products> getAllProductPriceSumDetails();

    @Query(value = "select id,date1 from products where qty<10",nativeQuery = true)
    public List<Object> outOfStockCount();

    @Query(value = "select * from products where qty<10",nativeQuery = true)
    public List<Products> outOfStockProducts();
//
//    @Query(value = "select * from products",nativeQuery = true)


}
