package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hassan on 2/12/2020.
 */
@Service
public class DashboardService {

    @Autowired
    ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;

    public ApiResponse productsQuantity(){
        return new ApiResponse(Status.Status_Ok,"sucessfully fetch total products",productsRepository.productQuantity());
    }
}
