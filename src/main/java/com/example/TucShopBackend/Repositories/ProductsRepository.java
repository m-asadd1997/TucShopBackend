package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ProfitDTO;
import com.example.TucShopBackend.DTO.VariantsDTO;

import com.example.TucShopBackend.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long> {


    @Query(value = "select * from product where category_id =:id AND active=1 ",nativeQuery = true)
    public List<Product> getAllByCategoryId(@Param("id") Long id);

    @Query(value="select * from product where name = :name and variants= :variant", nativeQuery = true)
    public List<Product> findByName(String name, String variant);

//    @Query(value = "select variants from products",nativeQuery = true)
//    public List<String> findByVariants();

    @Query(value = "select * from product where name =:name",nativeQuery = true)
    public String getAllByCategoryName(@Param("name") String name);

    @Query(value = "select COUNT(id) from product where active =1",nativeQuery = true)
        public Double  productQauntity();

    @Query(value = "select * from product p where p.date1 BETWEEN cast(:startDate as date)AND cast(:endDate as date)", nativeQuery = true)
    public List<Product> productQauntityDetails(String startDate,String endDate);

//    @Query(value = "select * from products ",nativeQuery = true)
//    public List<Product> getAllProductPriceSumDetails();

    @Query(value = "select COUNT(id) from product p where p.qty<10 AND active=1",nativeQuery = true)
    public List<Object> outOfStockCount();

    @Query(value = "select * from product where qty<10 AND active=1",nativeQuery = true)
    public List<Product> outOfStockProducts();
//
//    @Query(value = "select * from products",nativeQuery = true)

    @Query(value = "select * from product where name LIKE :name% AND active=1",nativeQuery = true)


    public List<Product> findByChar(@Param("name")String name);

    @Query(value = "select new com.example.TucShopBackend.DTO.VariantsDTO(id, name, variants) from Product where variants LIKE %:keyword% AND active=1 group by variants ")
    public List<VariantsDTO> getVariants(@Param("keyword")String keyword);


    @Query(value = "SELECT * FROM product WHERE name LIKE :keyword% AND active =1 " , nativeQuery = true)
    public List<Product> searchProductByKeyword(@Param("keyword")String keyword);


    @Query(value = "Select new com.example.TucShopBackend.DTO.ProfitDTO (t.date,(sum((p.price-p.costprice)*pt.quantity)) as profit) " +
            "from ProductTransaction pt, Transactions t, Product p " +
            "where pt.product.id = p.id AND pt.transaction.id = t.id AND t.date  BETWEEN  cast(:startDate as date) AND cast(:endDate as date) AND  t.status='complete'")
    public List<ProfitDTO> getProfit(@Param("startDate") String startDate, @Param("endDate") String endDate);



    @Query(value="Select COUNT(id) from product d where d.date1 BETWEEN cast(:startDate as date)AND cast(:endDate as date)",nativeQuery = true)
    public Double filteredQuantity(String startDate,String endDate);

    @Query(value="Select * from product d where d.date1 BETWEEN cast(:startDate as date)AND cast(:endDate as date) AND d.qty<10",nativeQuery = true)
    public List<Product> outOfStockFiltered(String startDate, String endDate);


    @Query(value = "Select new com.example.TucShopBackend.DTO.ProfitDTO (t.date,(sum((p.price-p.costprice)*pt.quantity)) as profit) " +
            "from ProductTransaction pt, Transactions t, Product p " +
            "where pt.product.id = p.id AND pt.transaction.id = t.id AND t.status='complete' ")
    public  List<Object>  getTotalprofit();

    @Query(value = "Select Sum(costprice*qty) from tucshop.product where active =1;",nativeQuery = true)
    public Long getTotalInventory();


    @Query(value = "Select Sum(costprice*qty)from tucshop.product p where p.date1 BETWEEN cast(:startDate as date)AND cast(:endDate as date)",nativeQuery = true)
    public Long getFilteredTotalInventory(@Param("startDate") String startDate, @Param("endDate") String endDate);


    @Query(value = "select * from tucshop.product where active = 1",nativeQuery = true)
    List<Product> getAll();

    @Query(value = "select * from tucshop.product where active = 1", nativeQuery = true)
    Page<Product> findByCondition(Pageable pageable);
}
