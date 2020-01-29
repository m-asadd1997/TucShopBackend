package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse saveProducts(ProductsDTO productsDTO){


        Products products1 = productsRepository.findByName(productsDTO.getName());

        if(products1 == null) {

            Products products = new Products();

            products.setCategory(productsDTO.getCategory());
            products.setDescription(productsDTO.getDescription());
            products.setImage(productsDTO.getImage());
            products.setPrice(productsDTO.getPrice());
            products.setName(productsDTO.getName());

            productsRepository.save(products);
            return new ApiResponse(200, "Success", products);
        }
        else{
            return new ApiResponse(200, "Product Already Exists", null);
        }
    }

    public ApiResponse getProductsByCategory(String category){
        Category category1 = categoryRepository.findCategoriesByName(category);

        List<Products> products = productsRepository.getAllByCategoryId(category1.getId());

        return new ApiResponse(200,"success",products); //products;
    }
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }
    public Object getProductById(Long id){
        return productsRepository.findById(id);
    }
    public ApiResponse deleteAll(){
        productsRepository.deleteAll();
        return new ApiResponse(200,"Delete All Successfully",null  );
    }
    public ApiResponse deleteProductById(Long id){
        productsRepository.deleteById(id);
        return new ApiResponse(200, "Product Deleted", null);
    }
    public ApiResponse updateById(Long id , ProductsDTO productsDTO){

        Optional<Products> productOptional = productsRepository.findById(id);
        Products product1 = productOptional.get();
        product1.setName(productsDTO.getName());
        product1.setImage(productsDTO.getImage());
        product1.setDescription(productsDTO.getDescription());
        product1.setPrice(productsDTO.getPrice());
        productsRepository.save(product1);
        return new ApiResponse(200, "Updated Successfully",product1);
    }
}
