package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Services.ProductsService;
import com.example.TucShopBackend.Services.RequestForProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    RequestForProductService requestForProductService;

    @Autowired
    ProductsService productsService;


    @PostMapping("/postreqproduct")
    public ApiResponse saveRequestForProduct(@RequestBody RequestForProductDTO requestForProduct){
        return requestForProductService.saveRequestForProduct(requestForProduct);

    }

    @PostMapping("/postproduct")
    public ApiResponse saveProducts(@RequestBody ProductsDTO productsDTO){
        return productsService.saveProducts(productsDTO);
    }

    @GetMapping("/{category}")
    public ApiResponse getProductsByCategory(@PathVariable("category") String category){
        return productsService.getProductsByCategory(category);
    }
    //Get All Products
    @GetMapping("/")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    //Get Product on the basis of ID
    @GetMapping("/p/{id}")
    public Object getProductById(@PathVariable("id") Long id){
        return productsService.getProductById(id);
    }
    //Delete All Products
    @DeleteMapping("/")
    public ApiResponse deleteAll(){
        return productsService.deleteAll();
    }

    //Delete Product on the basis of ID
    @DeleteMapping("/d/{id}")
    public ApiResponse deleteProductById(@PathVariable("id") Long id){
        return productsService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse updateById(@PathVariable("id") Long id ,@RequestBody ProductsDTO productsDTO){
        return productsService.updateById(id,productsDTO);
    }


}
