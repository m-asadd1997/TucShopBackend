package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hassan on 2/12/2020.
 */
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/totalproducts")
    public ApiResponse productsQuantity(){
        return dashboardService.productsQuantity();
    }
}
