package com.example.TucShopBackend.Services;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.OrderDetailsDTO;
import com.example.TucShopBackend.Models.Order_Details;
import com.example.TucShopBackend.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;


@Service
public class OrderService {

     @Autowired
     OrderRepository orderRepository;

    public ApiResponse postOrder(OrderDetailsDTO orderDTO){

        Order_Details order = new Order_Details();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Instant instant = Instant.now();
        Long timeStampSeconds = instant.getEpochSecond();
        order.setFirstName(orderDTO.getFname());
        order.setLastName(orderDTO.getLname());
        order.setAddress(orderDTO.getAddress());
        order.setEmailAddress(orderDTO.getEmail());
        order.setCartSubTotal(orderDTO.getCardAmount());
        order.setOrderTotal(orderDTO.getOrderAmount());
        order.setPhone(orderDTO.getPhone());
        order.setPostCodeZip(orderDTO.getPostcode());
        order.setShipping(orderDTO.getShipping());
        order.setStateCountry(orderDTO.getCountry());
        order.setTownCity(orderDTO.getCity());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setOrderDate(localDate);
        order.setOrderTime(localTime);
        order.setUuid(timeStampSeconds);

     return  new ApiResponse(Status.Status_Ok, "Saved to order", orderRepository.save(order));

    }
}
