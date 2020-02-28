package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import com.example.TucShopBackend.Repositories.RequestForProductRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hassan on 2/12/2020.
 */
@Service
public class DashboardService {

    @Autowired
    ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    RequestForProductRepository requestForProductRepository;

    public ApiResponse productsQuantity(){
        return new ApiResponse(Status.Status_Ok,"Sucessfully fetch total products",productsRepository.productQauntity());
    }
    public ApiResponse  productQuantityDetails(){
        return new ApiResponse(Status.Status_Ok,"Total products Details",productsRepository.productQauntityDetails());
    }

    public ApiResponse outOfStockProductsDetails(){
        return  new ApiResponse(Status.Status_Ok,"Out of Stock Products", productsRepository.outOfStockProducts());
    }
    public  ApiResponse outOfStockProducts(){
        return new ApiResponse(Status.Status_Ok, "Out of Stock", productsRepository.outOfStockCount());
    }

    public ApiResponse totalTransaction(){
        return new ApiResponse(Status.Status_Ok,"Successfully fetch Total Transation",transactionsRepository.getTotalTransaction());
    }

    public ApiResponse transactionDetails(){
        return new ApiResponse(Status.Status_Ok,"Get Transaction Details", transactionsRepository.getTransactionDetails());
    }

    public ApiResponse requestedProducts(){

        List<RequestForProductDTO> topRequestedProducts= requestForProductRepository.topRequestedProducts();

        return new ApiResponse(Status.Status_Ok,"Successfully get top requested Products",topRequestedProducts);
    }
}
