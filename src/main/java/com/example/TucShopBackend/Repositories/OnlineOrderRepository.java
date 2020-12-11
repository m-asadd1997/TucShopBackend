package com.example.TucShopBackend.Repositories;


import com.example.TucShopBackend.Models.Online_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnlineOrderRepository extends JpaRepository<Online_Order,Long> {

    @Query(value = "select * from online_order where order_status =:value",nativeQuery = true)
    List<Online_Order> getAllByOrderStatus(@Param("value") String value);

    @Query(value = "select * from online_order where phone =:value",nativeQuery = true)
    Online_Order getPhoneNo(@Param("value") String value);

    @Query(value = "select * from online_order where uuid =:value",nativeQuery = true)
    Online_Order getTrackingId(@Param("value") Long value);

}
