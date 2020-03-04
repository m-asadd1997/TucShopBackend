package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hassan on 2/12/2020.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/totalproducts")
    public ApiResponse productsQuantity(){
        return dashboardService.productsQuantity();
    }

    @GetMapping("/outofstockdetails")
    public ApiResponse outOfStockProductsDetails(){
        return dashboardService.outOfStockProductsDetails();
    }

    @GetMapping("/outofstock")
    public ApiResponse outofStockProducts(){
        return  dashboardService.outOfStockProducts();
    }

    @GetMapping("/totalproductdetails")
    public ApiResponse productQuantityDetails(){
        return dashboardService.productQuantityDetails();
    }

    @GetMapping("/totaltransaction")
    public ApiResponse totalTransaction(){
        return dashboardService.totalTransaction();
    }

    @GetMapping("/transactiondetails")
    public ApiResponse transactionDetails(){
        return dashboardService.transactionDetails();
    }

    @GetMapping("/toprequestedproducts")
    public ApiResponse requestedProducts(){
        return dashboardService.requestedProducts();
    }

    @GetMapping("/salespermonth")
    public ApiResponse getMonthlySales(){
        return dashboardService.getMonthlySales();
    }

}
