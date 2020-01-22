package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Services.RequestForProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    RequestForProductService requestForProductService;


    @PostMapping("/postreqproduct")
    public String saveRequestForProduct(@RequestBody RequestForProductDTO requestForProduct){
        return requestForProductService.saveRequestForProduct(requestForProduct);

    }


}
