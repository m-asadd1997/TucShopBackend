package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Repositories.RequestForProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
@Service
public class RequestForProductService {

    @Autowired
    RequestForProductRepository requestForProductRepository;

    public ApiResponse saveRequestForProduct(RequestForProductDTO requestForProductDTO){

        RequestForProduct requestForProduct = new RequestForProduct();
        requestForProduct.setName(requestForProductDTO.getName());
        requestForProductRepository.save(requestForProduct);
        return new ApiResponse(Status.Status_Ok,"Success",requestForProduct);

    }


}
