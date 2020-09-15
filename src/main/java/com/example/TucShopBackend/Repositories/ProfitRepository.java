package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ProfitDTO;
import com.example.TucShopBackend.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfitRepository extends JpaRepository<Product,Long> {


    @Query(value = "select new  com.example.TucShopBackend.DTO.ProfitDTO(t.date,((p.price-p.costprice)*pt.quantity)) from ProductTransaction pt,Transactions t,Product p where pt.product.id=p.id AND pt.transaction.id=t.id")
    public List<ProfitDTO> profitCalculation();
}
