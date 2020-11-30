package com.example.TucShopBackend.Repositories;


import com.example.TucShopBackend.Models.Order_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order_Details,Long> {



}
