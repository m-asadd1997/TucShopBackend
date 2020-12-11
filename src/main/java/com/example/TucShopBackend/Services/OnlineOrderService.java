package com.example.TucShopBackend.Services;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.OnlineOrderDTO;
import com.example.TucShopBackend.Models.Online_Order;
import com.example.TucShopBackend.Repositories.OnlineOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;



@Service
public class OnlineOrderService {

     @Autowired
     OnlineOrderRepository onlineOrderRepository;

    public ApiResponse postOrder(OnlineOrderDTO onlineOrderDTO){

        Online_Order order = new Online_Order();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Instant instant = Instant.now();
        Long timeStampSeconds = instant.getEpochSecond();
        order.setFirstName(onlineOrderDTO.getFname());
        order.setLastName(onlineOrderDTO.getLname());
        order.setAddress(onlineOrderDTO.getAddress());
        order.setEmailAddress(onlineOrderDTO.getEmail());
        order.setCartSubTotal(onlineOrderDTO.getCardAmount());
        order.setOrderTotal(onlineOrderDTO.getOrderAmount());
        order.setPhone(onlineOrderDTO.getPhone());
        order.setPostCodeZip(onlineOrderDTO.getPostcode());
        order.setShipping(onlineOrderDTO.getShipping());
        order.setStateCountry(onlineOrderDTO.getCountry());
        order.setTownCity(onlineOrderDTO.getCity());
        order.setOrderStatus(onlineOrderDTO.getOrderStatus());
        order.setOrderDate(localDate);
        order.setOrderTime(localTime);
        order.setUuid(timeStampSeconds);
        order.setCart(onlineOrderDTO.getCart());
     return  new ApiResponse(Status.Status_Ok, "Saved to Order Details", onlineOrderRepository.save(order));

    }


    public ApiResponse getAll() {
        List<Online_Order> onlineOrders = onlineOrderRepository.findAll();
        return new ApiResponse(Status.Status_Ok,"Order Details Found", onlineOrders);
    }


    public ApiResponse getById(Long id){
        Optional<Online_Order> onlineOrder = onlineOrderRepository.findById(id);
        if(onlineOrder.isPresent()) {
            return new ApiResponse(Status.Status_Ok, "Order Details Found", onlineOrder.get());
        }
        else {
            return new ApiResponse(Status.Status_ERROR, "Order Details Not Found", null);
        }
    }


    public  ApiResponse changeStatus (Long id, OnlineOrderDTO onlineOrderDTO){
        Optional <Online_Order> onlineOrder = onlineOrderRepository.findById(id);
        if(onlineOrder.isPresent()){
          Online_Order onlineOrder1 = onlineOrder.get();
          onlineOrder1.setOrderStatus(onlineOrderDTO.getOrderStatus());
          onlineOrderRepository.save(onlineOrder1);
          return new ApiResponse(Status.Status_Ok, "Order Status Changed Successfully", onlineOrder1);
        }else
        {
            return new ApiResponse(Status.Status_ERROR, "Order Status Not Changed", null);
        }
    }


    public  ApiResponse getOrderStatusOnSelect (String value){
        List<Online_Order> onlineOrder = onlineOrderRepository.getAllByOrderStatus(value);
        if(onlineOrder.size()>0) {
            return new ApiResponse(Status.Status_Ok, "Order Status Successfully Get", onlineOrder);
        }else
        {
            return new ApiResponse(Status.Status_ERROR, "Order Status Not Found", null);
        }
        }

    public  ApiResponse getPhoneNo (String value){
    Online_Order onlineOrder = onlineOrderRepository.getPhoneNo(value);
    if(onlineOrder!=null) {
        return new ApiResponse(Status.Status_Ok, "Order Phone No Successfully Get", onlineOrder);
    }else{
        return new ApiResponse(Status.Status_ERROR, "Order Phone no Not Found", null);
    }
    }


    public  ApiResponse getTrackingId (Long value){
        Online_Order onlineOrder = onlineOrderRepository.getTrackingId(value);
        if(onlineOrder!=null) {
            return new ApiResponse(Status.Status_Ok, "Order Tracking ID Successfully Get", onlineOrder);
        }else{
            return new ApiResponse(Status.Status_ERROR, "Order Tracking ID Not Found", null);
        }
    }





}
