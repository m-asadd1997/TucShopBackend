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


    @Query(value = "select new com.example.TucShopBackend.DTO.RequestForProductDTO(id,name as name,count(name)as countname) from RequestForProduct  group by name order by count(name) desc")
    public List<RequestForProductDTO> topRequestedProductsCount();


    @Query(value = "select new com.example.TucShopBackend.DTO.RequestForProductDTO(id, name as name,count(name)as countname) from RequestForProduct where name LIKE %:keyword% group by name order by count(name) desc")
    public List<RequestForProductDTO> topRequestedProductsKeyword(@Param("keyword")String keyword);


}
