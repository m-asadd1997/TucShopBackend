package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse saveProducts(ProductsDTO productsDTO){


        Products productsName = productsRepository.findByName(productsDTO.getName());

        if(productsName == null) {

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            Category category = getCategoryById(productsDTO.getCategory().getId());
            if(category == null){
                return new ApiResponse(200, "Failed to find category",null);
            }
            if(saveProductImage(productsDTO.getImage(),category.getName(),unique)){

            Products products = new Products();
            products.setImage("http://localhost:8080/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
            products.setCategory(category);
            products.setDescription(productsDTO.getDescription());
            products.setPrice(productsDTO.getPrice());
            products.setName(productsDTO.getName());
            productsRepository.save(products);
            return new ApiResponse(200, "Success", products);
        }
            }
        else{
            return new ApiResponse(409, "Product Already Exists", null);
        }

        return new ApiResponse(401,"Image not saved",null);
    }

    private Category getCategoryById(Long id) {
        Optional<Category> category =categoryRepository.findById(id);
        return category.isPresent()? category.get() : null;
    }

    public Boolean saveProductImage(MultipartFile file, String name, String unique  ){
        try{


        String UPLOADED_FOLDER_NEW = "E://TuckshopBackend_Main//TucShopBackend//serverFiles//"+name+"//"+"products"+"//";

            File dir = new File(UPLOADED_FOLDER_NEW);
            dir.setExecutable(true);
            dir.setReadable(true);
            dir.setWritable(true);

            if(!dir.exists()){
                dir.mkdirs();
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER_NEW + unique+ file.getOriginalFilename());
            Files.write(path, bytes);

        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResponseEntity<InputStreamResource> getProductImage(String filename, String category) throws IOException{
        String filepath = "E://TuckshopBackend_Main/TucShopBackend//serverFiles//"+category+"//products//"+filename;
        File f = new File(filepath);
        Resource file = new UrlResource(f.toURI());
        return  ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(
                        MediaType.parseMediaType("image/JPG"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    public ApiResponse getProductsByCategory(String category){
        Category category1 = categoryRepository.findCategoriesByName(category);

        List<Products> products = productsRepository.getAllByCategoryId(category1.getId());

        return new ApiResponse(200,"Success",products); //products;
    }
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }
    public Products getProductById(Long id){
        Optional<Products> product =  productsRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        else{
            return new Products();
        }
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
//        product1.setImage(productsDTO.getImage());
        product1.setDescription(productsDTO.getDescription());
        product1.setPrice(productsDTO.getPrice());
        productsRepository.save(product1);
        return new ApiResponse(200, "Updated Successfully",product1);
    }
}
