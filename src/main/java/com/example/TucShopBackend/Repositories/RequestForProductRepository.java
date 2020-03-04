package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.RequestForProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
public interface RequestForProductRepository extends JpaRepository<RequestForProduct,Long> {

    @Query(value = "select count(name),name,id,count(id) from request_for_product group by name order by count(name) desc limit 5;", nativeQuery = true)
    public List<RequestForProduct> topRequestedProducts();


}
