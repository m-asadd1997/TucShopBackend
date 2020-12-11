package com.example.TucShopBackend.Controllers;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.OnlineOrderDTO;
import com.example.TucShopBackend.Services.OnlineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OnlineOrderController {

    @Autowired
    OnlineOrderService onlineOrderService;


    @PostMapping("/")
    public ApiResponse postOrder(@RequestBody OnlineOrderDTO onlineOrderDTO){ return onlineOrderService.postOrder(onlineOrderDTO); }

    @GetMapping("/")
    public ApiResponse getAll() { return onlineOrderService.getAll(); }

    @GetMapping ("/{id}")
    public ApiResponse getById (@PathVariable("id") Long id ){ return this.onlineOrderService.getById(id); }

    @PatchMapping("/{id}")
    public  ApiResponse changeStatus(@PathVariable ("id") Long id,@RequestBody OnlineOrderDTO onlineOrderDTO) { return  this.onlineOrderService.changeStatus(id,onlineOrderDTO);}

    @GetMapping("/status/{value}")
    public ApiResponse getOrderStatusOnSelect(@PathVariable ("value") String value) {
        return this.onlineOrderService.getOrderStatusOnSelect(value);
    }

    @GetMapping ("/phoneno/{value}")
    public  ApiResponse getPhone(@PathVariable("value")String value){
    return  this.onlineOrderService.getPhoneNo(value);
    }

    @GetMapping("/trackingid/{value}")
    public  ApiResponse getTrackingId (@PathVariable("value") Long value){
    return  this.onlineOrderService.getTrackingId(value);
    }



}
