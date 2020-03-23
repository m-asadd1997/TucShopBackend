package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.SettingsDTO;
import com.example.TucShopBackend.Models.Settings;
import com.example.TucShopBackend.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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
    public ApiResponse requestedProducts() { return this.dashboardService.requestedProductsCount();
    }

    @GetMapping("/autocomplete/{keyword}")
    public ApiResponse autoComplete(@PathVariable ("keyword") String keyword) { return this.dashboardService.requestedProductsKeyword(keyword);
    }

        @GetMapping("/salespermonth")
    public ApiResponse getMonthlySales(){
        return dashboardService.getMonthlySales();
    }

    @PostMapping ("/settings")
    public  ApiResponse settings(@Valid @RequestParam ("logo")MultipartFile logo, SettingsDTO settingsDTO){ settingsDTO.setLogo(logo);
      return  dashboardService.postSettings(settingsDTO);
    }

    @RequestMapping(value = "/image/{header}/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename, @PathVariable("header") String header)
            throws IOException {
        return dashboardService.getSettingLogo(filename,header);
    }

    @GetMapping ("/settings")
    public List<Settings> getAll (SettingsDTO settingsDTO ){
        return dashboardService.getAll();
    }

}
