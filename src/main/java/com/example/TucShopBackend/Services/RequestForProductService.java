package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
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

    Long count=1L;
    @Autowired
    RequestForProductRepository requestForProductRepository;

    public ApiResponse saveRequestForProduct(RequestForProduct requestForProductDTO){

        RequestForProduct findProduct=requestForProductRepository.findByname(requestForProductDTO.getName());
        if(findProduct==null) {


            RequestForProduct requestForProduct = new RequestForProduct();
            requestForProduct.setName(requestForProductDTO.getName());
            requestForProduct.setDate1(requestForProductDTO.getTodaysDate());
            requestForProduct.setCount(1L);
            requestForProductRepository.save(requestForProduct);
            return new ApiResponse(Status.Status_Ok, "Success", requestForProduct);
        }
        else{


            findProduct.setCount(findProduct.getCount()+1);
            requestForProductRepository.save(findProduct);
            return new ApiResponse(200,"counter incremented",findProduct);
        }

    }

    public ApiResponse deleteRequestedProduct(String productName){
        RequestForProduct product=requestForProductRepository.findByname(productName);
        requestForProductRepository.delete(product);
        return new ApiResponse(200,"successfully deleted",product);
    }

}
