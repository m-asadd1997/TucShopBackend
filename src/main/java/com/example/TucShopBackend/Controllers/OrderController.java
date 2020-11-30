package com.example.TucShopBackend.Controllers;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.OrderDetailsDTO;
import com.example.TucShopBackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/")
    public ApiResponse postOrder(@RequestBody OrderDetailsDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }

}
