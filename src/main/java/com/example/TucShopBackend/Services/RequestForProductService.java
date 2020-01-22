package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Repositories.RequestForProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
@Service
public class RequestForProductService {

    @Autowired
    RequestForProductRepository requestForProductRepository;

    public String saveRequestForProduct(RequestForProductDTO requestForProductDTO){

        RequestForProduct requestForProduct = new RequestForProduct();
        requestForProduct.setName(requestForProductDTO.getName());
        requestForProductRepository.save(requestForProduct);
        return "{\"ADDED SUCCESFULLY\":1}";

    }
}
