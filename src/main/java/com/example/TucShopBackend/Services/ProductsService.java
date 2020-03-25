package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;

import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.CategoryDTO;

import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.VariantsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.query.Param;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Value("${product.image.url}")
    String productImageUrl;

    public ApiResponse getVariants(String keyword){
        List<VariantsDTO> variantsList = productsRepository.getVariants(keyword);
        return new ApiResponse(Status.Status_Ok,"Success",variantsList);
    }

    public ApiResponse saveProducts(ProductsDTO productsDTO){

        List<Products> productsName = productsRepository.findByName(productsDTO.getName());

        Boolean flag = false;

        for(int i=0;i<productsName.size(); i++){

            if(productsName.get(i).getVariants().equals(productsDTO.getVariants()) ){
                flag = true;
            }
        }

        if(productsName == null || !flag) {

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            Category category = getCategoryById(productsDTO.getCategory().getId());

            if(category == null){
                return new ApiResponse(Status.Status_ERROR, CustomConstants.CAT_GETERROR,null);
            }

            if(saveProductImage(productsDTO.getImage(),category.getName(),unique)) {

                Products products = new Products();
                products.setImage(productImageUrl + category.getName() + "/" + productsDTO.getName() + "/" + unique + productsDTO.getImage().getOriginalFilename());
                products.setCategory(category);
                products.setDescription(productsDTO.getDescription());
                products.setPrice(productsDTO.getPrice());
                products.setQty(productsDTO.getQuantity());
                products.setCostprice(productsDTO.getCostprice());
                products.setName(productsDTO.getName());
                products.setVariants(productsDTO.getVariants());
                productsRepository.save(products);
                return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, products);
            }
        }


        else{
            return new ApiResponse(Status.Status_DUPLICATE, CustomConstants.PROD_DUPLICATE, null);
        }

        return new ApiResponse(Status.Status_ERROR,CustomConstants.PRODIMAGE_ERROR,null);
    }

    private Category getCategoryById(Long id) {
        Optional<Category> category =categoryRepository.findById(id);
        return category.isPresent()? category.get() : null;
    }

    public Boolean saveProductImage(MultipartFile file, String name, String unique  ){
        try{

        String UPLOADED_FOLDER_NEW = "C://TuckshopBackend_Main//TucShopBackend//serverFiles//"+name+"//"+"products"+"//";

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
        String filepath = "C://TuckshopBackend_Main/TucShopBackend//serverFiles//"+category+"//products//"+filename;
        File f = new File(filepath);
        Resource file = new UrlResource(f.toURI());
        return  ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(
                        MediaType.parseMediaType("image/JPG"))
                .body(new InputStreamResource(file.getInputStream()));
    }

//    public  double getAllSum(Long id){
//       return productsRepository.findByCategory_Id(id);
//
//    }

    public ApiResponse getProductsByCategory(String category){
        Category category1 = categoryRepository.findCategoriesByName(category);

        List<Products> products = productsRepository.getAllByCategoryId(category1.getId());

        return new ApiResponse(Status.Status_Ok,CustomConstants.PROD_GET,products); //products;
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
        return new ApiResponse(Status.Status_Ok,CustomConstants.PROD_DELETE,null  );
    }
    public ApiResponse deleteProductById(Long id){
        productsRepository.deleteById(id);
        return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_DELETE, null);
    }

    public ApiResponse updateById(Long id , ProductsDTO productsDTO) {

        Category category = getCategoryById(productsDTO.getCategory().getId());

        if(category == null){
            return new ApiResponse(200, CustomConstants.CAT_GETERROR,null);
        }

        Optional<Products>findProduct = productsRepository.findById(id);
        Products product = findProduct.get();

        if(productsDTO.getImage().getOriginalFilename().isEmpty()) {
            product.setImage(null);
            return populateResponse(productsDTO, category, product);
        }

         if(product.getImage()!=null && product.getImage().equalsIgnoreCase( productsDTO.getImage().getName())){

             return populateResponse(productsDTO, category, product);
         }
         else{

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

            if (saveProductImage(productsDTO.getImage(), category.getName(), unique)) {

                product.setName(productsDTO.getName());
                product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
                product.setDescription(productsDTO.getDescription());
                product.setPrice(productsDTO.getPrice());
                product.setQty(productsDTO.getQuantity());
                product.setCostprice(productsDTO.getCostprice());
                product.setCategory(category);
                productsRepository.save(product);
                return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);
            }

        return new ApiResponse(401,CustomConstants.PRODIMAGE_ERROR,null);

        }

    }

    private ApiResponse populateResponse(ProductsDTO productsDTO, Category category, Products product) {
        product.setName(productsDTO.getName());
        product.setDescription(productsDTO.getDescription());
        product.setPrice(productsDTO.getPrice());
        product.setQty(productsDTO.getQuantity());
        product.setCostprice(productsDTO.getCostprice());
        product.setCategory(category);
        productsRepository.save(product);
        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);

    }

}
