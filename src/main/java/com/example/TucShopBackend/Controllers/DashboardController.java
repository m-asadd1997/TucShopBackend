package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ProfitDTO;
import com.example.TucShopBackend.DTO.SettingsDTO;
import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.Settings;
import com.example.TucShopBackend.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/filteredtotalproducts/{startDate}/{endDate}")
        public ApiResponse filteredProducts(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate)
        {
                return dashboardService.filteredQuantity(startDate,endDate);
        }


    @GetMapping("/outofstockdetails")
    public ApiResponse outOfStockProductsDetails(){
        return dashboardService.outOfStockProductsDetails();
    }

    @GetMapping("/outofstock")
    public ApiResponse outofStockProducts(){
        return  dashboardService.outOfStockProducts();
    }

    @GetMapping("/outofstockfiltered/{startDate}/{endDate}")
    public ApiResponse outofStockFilteredProducts(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate){
        return  dashboardService.outOfStockFilteredProducts(startDate,endDate);
    }

    @GetMapping("/totalproductdetails/{startDate}/{endDate}")
    public ApiResponse productQuantityDetails(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate){
        return dashboardService.productQuantityDetails(startDate,endDate);
    }

    @GetMapping("/totaltransaction")
    public ApiResponse totalTransaction(){
        return dashboardService.totalTransaction();
    }

    @GetMapping("/filteredtransaction/{startDate}/{endDate}")
    public ApiResponse transactionsFiltered(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate){
        return  dashboardService.filteredTransaction(startDate,endDate);
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
    public  ApiResponse settings(@Valid @RequestParam (value = "logo",required = false)MultipartFile logo, SettingsDTO settingsDTO)
    {   if(logo!=null)
        settingsDTO.setLogo(logo);
      return  dashboardService.postSettings(settingsDTO);
    }

    @RequestMapping(value = "/image/settings/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename)
            throws IOException {
        return dashboardService.getSettingLogo(filename);
    }

    @GetMapping ("/settings")
    public List<Settings> getAll (SettingsDTO settingsDTO ){
        return dashboardService.getAll();
    }

    @GetMapping("/detailedfilteretransactions/{startDate}/{endDate}")
    public ApiResponse detailedFilteredTransactions(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate){
        return dashboardService.detailedFilteredTransaction(startDate,endDate);
    }

    @GetMapping("/searchproducts/{name}")
    public List<Product> getSearchedProducts(@PathVariable String name)
    {
        return dashboardService.getSearchedProducts(name);
    }

    @GetMapping("/profit/{startDate}/{endDate}")
    public  ApiResponse getProfit(@PathVariable ("startDate") String startDate, @PathVariable ("endDate") String endDate){
        return dashboardService.getProfit(startDate, endDate);

    }

    @GetMapping("/totalprofit")
    public ApiResponse getTotalProfit(){

        return dashboardService.getTotalProfit();
    }

    @GetMapping("/totalinventory")
    public ApiResponse getTotalInvestment(){
        return dashboardService.getTotalInventory();
    }

    @GetMapping("/totalinventory/{startDate}/{endDate}")
    public ApiResponse getFilteredTotalInventory(@PathVariable ("startDate") String startDate, @PathVariable ("endDate") String endDate){
        return dashboardService.getFilteredTotalInventory(startDate,endDate);
    }

    @GetMapping("/frequencybycategory")
    public ApiResponse getCategoryFrequency(){
        return dashboardService.getCategoryFrequency();
    }

    @GetMapping("/gettransactionmethod")
    public ApiResponse getTransactionMethod(){
        return dashboardService.getTransactionMethod();
    }

    @GetMapping("/frequencybycategory/{startDate}/{endDate}")
    public ApiResponse getFilteredCategoryFrequency(@PathVariable ("startDate") String startDate, @PathVariable ("endDate") String endDate){
        return dashboardService.getFilteredCategoryFrequency(startDate,endDate);
    }

    @GetMapping("/gettransactionmethod/{startDate}/{endDate}")
    public ApiResponse getFilteredTransactionMethod(@PathVariable ("startDate") String startDate, @PathVariable ("endDate") String endDate){
        return dashboardService.getFilteredTransactionMethod(startDate,endDate);
    }

}
