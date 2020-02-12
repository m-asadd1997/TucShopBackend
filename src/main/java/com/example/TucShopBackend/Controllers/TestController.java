package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hassan on 2/11/2020.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    ProductsService productsService;
//    @GetMapping("/{id}")
//    public double getAllSum(@PathVariable("id") Long id){
//        return productsService.getAllSum(id);
//    }

}
