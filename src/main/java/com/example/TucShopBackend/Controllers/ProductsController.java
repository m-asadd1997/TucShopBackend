package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.DTO.UpdateStockDTO;

import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Product;

import com.example.TucShopBackend.Models.RequestForProduct;

import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Services.ProductsService;
import com.example.TucShopBackend.Services.RequestForProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;

import java.io.IOException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    RequestForProductService requestForProductService;

    @Autowired
    ProductsService productsService;

//    @Autowired
//    CategoryRepository categoryRepository;

   //Request Product
    @PostMapping("/postreqproduct")
    public ApiResponse saveRequestForProduct(@Valid @RequestBody RequestForProduct requestForProduct){
        return requestForProductService.saveRequestForProduct(requestForProduct);

    }
    @GetMapping("/variants/{keyword}")
    public ApiResponse autoComplete(@PathVariable ("keyword") String keyword) {
        return productsService.getVariants(keyword);
    }
    @DeleteMapping("/deletereqproduct/{productName}")
    public ApiResponse deleteRequestedProduct(@PathVariable ("productName") String productName)
    {

        return requestForProductService.deleteRequestedProduct(productName);
    }

    //Post Product
    @PostMapping("/postproduct")
    public ApiResponse saveProducts(@RequestParam(value = "productImages",required = false) MultipartFile[] partImages, ProductsDTO productsDTO){
//        productsDTO.setImage(image);

        return productsService.saveProducts(partImages,productsDTO);
    }
    //Get Product according to Category
    @GetMapping("/category/{category}")
    public ApiResponse getProductsByCategory(@PathVariable("category") String category){
//        Category category1 = categoryRepository.findCategoriesByName(category);
        return productsService.getProductsByCategory(category);
    }
    //Get All Product
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productsService.getAllProducts();
    }

    //Get Product on the basis of ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productsService.getProductById(id);
    }
    //Delete All Product
    @DeleteMapping("/")
    public ApiResponse deleteAll(){
        return productsService.deleteAll();
    }

    //Delete Product on the basis of ID


    @DeleteMapping("/{id}")
    public ApiResponse deleteProductById(@PathVariable("id") Long id){
        return productsService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse updateById(@PathVariable("id") Long id ,@RequestParam("productImages") MultipartFile[] productImages, ProductsDTO productsDTO){
        return productsService.updateById(id,productImages,productsDTO);
    }
    @RequestMapping(value ="/image/{category}/{productName}/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getProductImage(@PathVariable("filename") String filename,  @PathVariable("category") String category)
            throws IOException {
        return productsService.getProductImage(filename,category);
    }


    @PutMapping ("/add/{id}")
    public ApiResponse AddQuantity( @PathVariable("id") Long id,@RequestBody UpdateStockDTO pdt ){

       // Product product = productsService.getProductById(id);
       // pdt.setImage(image);
        return  this.productsService.AddQty(id,pdt);

    }


    @PutMapping (value = "/minus/{id}")
    public ApiResponse SubtractQuantity( @PathVariable("id") Long id,@RequestBody UpdateStockDTO pdt ){

//        Product product = productsService.getProductById(id);
        //pdt.setImage(image);
        return  this.productsService.MinusQty(id,pdt);

    }
    @PutMapping (value = "/minusall/{id}")
    public ApiResponse SubtractAllQuantity( @PathVariable("id") Long id, @RequestBody UpdateStockDTO pdt ){

//        Product product = productsService.getProductById(id);
        //pdt.setImage(image);
        return  this.productsService.MinusAllQty(id,pdt);

    }


    @GetMapping("/search/{keyword}")
    public ApiResponse searchProductByKeyword(@PathVariable ("keyword") String keyword) {
        return this.productsService.searchProductByKeyword(keyword);
    }
    @GetMapping(value = "/paginatedproducts")
    public Page<Product> getAllPaginatedProducts(@RequestParam(defaultValue = "0") int page)
    {
        return productsService.joinAllProducts(PageRequest.of(page,10));

    }
    @GetMapping("/getbybarcode/{code}")
    public ApiResponse getByBarCode(@PathVariable("code") String code){
        return this.productsService.getProductByBarCode(code);
    }

    @GetMapping("/onlineproducts")
    public ApiResponse getOnlineProducts(){
        return productsService.getOnlineProductsOnHomePage();
    }

    @GetMapping("/onlineproductbyid/{id}")
    public ApiResponse getOnlineProductById(@PathVariable("id") Long id){
        return productsService.getOnlineProductById(id);
    }

    @GetMapping("/sortedonlineproduct/{sortorder}")
    public ApiResponse sortedonlineproductby(@PathVariable("sortorder") String sortorder){
        return productsService.sortedOnlineProductby(sortorder);
    }
}
