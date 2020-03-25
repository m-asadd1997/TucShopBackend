package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.VariantsDTO;
import com.example.TucShopBackend.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {


    @Query(value = "select * from products where category_id =:id ",nativeQuery = true)
    public List<Products> getAllByCategoryId(@Param("id") Long id);

    public List<Products> findByName(String name);

//    @Query(value = "select variants from products",nativeQuery = true)
//    public List<String> findByVariants();

    @Query(value = "select * from products where name =:name",nativeQuery = true)
    public String getAllByCategoryName(@Param("name") String name);

    @Query(value = "select COUNT(id) from products",nativeQuery = true)
    public Long productQauntity();

    @Query(value = "select * from products", nativeQuery = true)
    public List<Products> productQauntityDetails();

//    @Query(value = "select * from products ",nativeQuery = true)
//    public List<Products> getAllProductPriceSumDetails();

    @Query(value = "select count(id) from products where qty<10",nativeQuery = true)
    public Long outOfStockCount();

    @Query(value = "select * from products where qty<10",nativeQuery = true)
    public List<Products> outOfStockProducts();

    @Query(value = "select new com.example.TucShopBackend.DTO.VariantsDTO(id, name, variants) from Products where variants LIKE %:keyword% group by variants ")
    public List<VariantsDTO> getVariants(@Param("keyword")String keyword);

}
