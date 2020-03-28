package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.VariantsDTO;

import com.example.TucShopBackend.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long> {


    @Query(value = "select * from product where category_id =:id ",nativeQuery = true)
    public List<Product> getAllByCategoryId(@Param("id") Long id);

    public List<Product> findByName(String name);

//    @Query(value = "select variants from products",nativeQuery = true)
//    public List<String> findByVariants();

    @Query(value = "select * from product where name =:name",nativeQuery = true)
    public String getAllByCategoryName(@Param("name") String name);

    @Query(value = "select id ,date1 from product",nativeQuery = true)
        public List<Object>  productQauntity();

    @Query(value = "select * from product", nativeQuery = true)
    public List<Product> productQauntityDetails();

//    @Query(value = "select * from products ",nativeQuery = true)
//    public List<Product> getAllProductPriceSumDetails();

    @Query(value = "select id,date1 from product where qty<10",nativeQuery = true)
    public List<Object> outOfStockCount();

    @Query(value = "select * from product where qty<10",nativeQuery = true)
    public List<Product> outOfStockProducts();
//
//    @Query(value = "select * from products",nativeQuery = true)

    @Query(value = "select * from product where name LIKE :name%",nativeQuery = true)


    public List<Product> findByChar(@Param("name")String name);

    @Query(value = "select new com.example.TucShopBackend.DTO.VariantsDTO(id, name, variants) from Product where variants LIKE %:keyword% group by variants ")
    public List<VariantsDTO> getVariants(@Param("keyword")String keyword);


    @Query(value = "SELECT * FROM products WHERE name LIKE :keyword%", nativeQuery = true)
    public List<Products> searchProductByKeyword(@Param("keyword")String keyword);


}
