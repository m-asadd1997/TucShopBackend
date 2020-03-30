package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.RequestForProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */


@Repository
public interface RequestForProductRepository extends JpaRepository<RequestForProduct,Long> {

    @Query(value = "select id,count,date1,name from tucshop.request_for_product order by count desc limit 5",nativeQuery = true)
    public List<RequestForProduct> topRequestedProductsCount();


//    @Query(value = "select new com.example.TucShopBackend.DTO.RequestForProductDTO(id,name as name,count(name)as countname,date1 )  from RequestForProduct  group by name order by count(name) desc")
//    public List<RequestForProductDTO> topRequestedProductsCount();


//    @Query(value = "select new com.example.TucShopBackend.DTO.RequestForProductDTO(id, name as name,count ,date1) from RequestForProduct where name LIKE %:keyword% group by name order by count desc")
//    public List<RequestForProductDTO> topRequestedProductsKeyword(@Param("keyword")String keyword);

    @Query(value = "SELECT *  from tucshop.request_for_product WHERE name LIKE %:keyword%", nativeQuery = true)
    public List<RequestForProduct> topRequestedProductsKeyword(@Param("keyword")String keyword);

//    @Query(value = "select* from tucshop.request_for_product where name=:name",nativeQuery = true)
//    public List<RequestForProduct> findByname(@Param("name") String name);


    public RequestForProduct findByname( String name);

}
