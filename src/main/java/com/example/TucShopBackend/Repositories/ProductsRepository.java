package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ProfitDTO;
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


    @Query(value = "SELECT * FROM product WHERE name LIKE :keyword%", nativeQuery = true)
    public List<Product> searchProductByKeyword(@Param("keyword")String keyword);


    @Query(value = "Select new com.example.TucShopBackend.DTO.ProfitDTO (t.date,(sum((p.price-p.costprice)*pt.quantity)) as profit) " +
            "from ProductTransaction pt, Transactions t, Product p " +
            "where pt.product.id = p.id AND pt.transaction.id = t.id AND t.date  BETWEEN  cast(:startDate as date) AND cast(:endDate as date)")
    public List<ProfitDTO> getProfit(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "Select new com.example.TucShopBackend.DTO.ProfitDTO (t.date,(sum((p.price-p.costprice)*pt.quantity)) as profit) " +
            "from ProductTransaction pt, Transactions t, Product p " +
            "where pt.product.id = p.id AND pt.transaction.id = t.id ")
    public  List<Object>  getTotalprofit();

}
