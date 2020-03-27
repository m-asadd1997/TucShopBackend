package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;

import com.example.TucShopBackend.Commons.Status;

import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.VariantsDTO;
import com.example.TucShopBackend.DTO.UpdateStockDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import java.util.Map;
import java.util.Optional;

@Service
public class    ProductsService {

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
    @Value("${spring.profiles.active}")
    String profile;

    //serverfile.path
    @Value("${serverfile.path}")
    String serverFilePath;

    @Autowired
    private CloudinaryService cloudinaryService;

    public ApiResponse saveProducts(ProductsDTO productsDTO){

        List<Product> productName = productsRepository.findByName(productsDTO.getName());

        Boolean flag = false;

        for(int i = 0; i< productName.size(); i++){

                if(productName.get(i).getVariants().equals(productsDTO.getVariants()) ){
                flag = true;
            }
        }

        if(productName == null || !flag) {

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            Category category = getCategoryById(productsDTO.getCategory().getId());

            if(category == null){
                return new ApiResponse(Status.Status_ERROR, CustomConstants.CAT_GETERROR,null);
            }
                switch (profile){
                    case CustomConstants.DEV:
                        if(saveProductImage(productsDTO.getImage(),category.getName(),unique)){

                            Product product = new Product();
                            product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
                            product.setCategory(category);
                            product.setDescription(productsDTO.getDescription());
                            product.setPrice(productsDTO.getPrice());
                            product.setQty(productsDTO.getQuantity());
                            product.setCostprice(productsDTO.getCostprice());
                            product.setName(productsDTO.getName());
                            product.setDate1(productsDTO.getDate1());
                            product.setVariants(productsDTO.getVariants());
                            productsRepository.save(product);
                            return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);
                        }
                        break;

                    case CustomConstants.PROD:
                        try {
                            Map map =  cloudinaryService.upload(productsDTO.getImage());
                            Product product = new Product();
                            product.setImage(map.get("url").toString());
                            product.setCategory(category);
                            product.setDescription(productsDTO.getDescription());
                            product.setPrice(productsDTO.getPrice());
                            product.setQty(productsDTO.getQuantity());
                            product.setCostprice(productsDTO.getCostprice());
                            product.setName(productsDTO.getName());
                            product.setVariants(productsDTO.getVariants());
                            productsRepository.save(product);
                            return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }

            if(saveProductImage(productsDTO.getImage(),category.getName(),unique)) {

                Product product = new Product();
                product.setImage(productImageUrl + category.getName() + "/" + productsDTO.getName() + "/" + unique + productsDTO.getImage().getOriginalFilename());
                product.setCategory(category);
                product.setDescription(productsDTO.getDescription());
                product.setPrice(productsDTO.getPrice());
                product.setQty(productsDTO.getQuantity());
                product.setCostprice(productsDTO.getCostprice());
                product.setName(productsDTO.getName());
                product.setVariants(productsDTO.getVariants());
                productsRepository.save(product);
                return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);
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

        String UPLOADED_FOLDER_NEW = serverFilePath+"serverFiles//"+name+"//"+"products"+"//";

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
        String filepath = serverFilePath+"serverFiles//"+category+"//products//"+filename;
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

        List<Product> products = productsRepository.getAllByCategoryId(category1.getId());

        return new ApiResponse(Status.Status_Ok,CustomConstants.PROD_GET,products); //products;
    }

    public List<Product> getAllProducts(){
        return productsRepository.findAll();
    }

    public Product getProductById(Long id){
        Optional<Product> product =  productsRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        else{
            return new Product();
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

        Optional<Product>findProduct = productsRepository.findById(id);
        Product product = findProduct.get();

        if(productsDTO.getImage().getOriginalFilename().isEmpty()) {
            product.setImage(null);
            return populateResponse(productsDTO, category, product);
        }

         if(product.getImage()!=null && product.getImage().equalsIgnoreCase( productsDTO.getImage().getName())){

             return populateResponse(productsDTO, category, product);
         }
         else{
            switch (profile){
                case CustomConstants.DEV:
                    String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

                    if (saveProductImage(productsDTO.getImage(), category.getName(), unique)) {

                        product.setName(productsDTO.getName());
                        product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
                        product.setDescription(productsDTO.getDescription());
                        product.setPrice(productsDTO.getPrice());
                        product.setQty(productsDTO.getQuantity());
                        product.setCostprice(productsDTO.getCostprice());
                        product.setCategory(category);
                        product.setVariants(productsDTO.getVariants());
                        productsRepository.save(product);
                        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);
                    }
                    break;

                case CustomConstants.PROD:
                    try {
                        Map map =  cloudinaryService.upload(productsDTO.getImage());
                        product.setName(productsDTO.getName());
                        product.setImage(map.get("url").toString());
                        product.setDescription(productsDTO.getDescription());
                        product.setPrice(productsDTO.getPrice());
                        product.setQty(productsDTO.getQuantity());
                        product.setCostprice(productsDTO.getCostprice());
                        product.setCategory(category);
                        productsRepository.save(product);
                        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }


        return new ApiResponse(401,CustomConstants.PRODIMAGE_ERROR,null);

        }

    }

    private ApiResponse populateResponse(ProductsDTO productsDTO, Category category, Product product) {
        product.setName(productsDTO.getName());
        product.setDescription(productsDTO.getDescription());
        product.setPrice(productsDTO.getPrice());
        product.setQty(productsDTO.getQuantity());
        product.setCostprice(productsDTO.getCostprice());
        product.setCategory(category);
        productsRepository.save(product);
        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);

    }
        int count=0;
    public ApiResponse AddQty(Long id,UpdateStockDTO pdt ){
        Product pdt1 = getProductById(id);
//            ProductsDTO pdt= new ProductsDTO();
        double quantity=pdt1.getQty();
        if(quantity-1<0){

            pdt.setQuantity(0.0);
            return this.updateStockById(id,pdt);
        }
        else{
//            pdt1.setQty(quantity-1);
               pdt.setCount((pdt.getCount()+1));
            pdt.setQuantity(quantity-1);
            return this.updateStockById(id,pdt);

        }
    }


    public ApiResponse MinusQty(Long id , UpdateStockDTO pdt){
        Product pdt1 = getProductById(id);

        double quantity=pdt1.getQty();
        if(pdt.getCount()>0){

            pdt.setQuantity(quantity+1);
            pdt.setCount(pdt.getCount()-1);
            return this.updateStockById(id,pdt);
        }

        else {
            pdt.setQuantity(quantity);

            return this.updateStockById(id,pdt);
        }


    }


    public ApiResponse MinusAllQty(Long id , UpdateStockDTO pdt){
        Product pdt1 = getProductById(id);

        double quantity=pdt1.getQty();
            for (int i =0;i<pdt.getCount();i++){
                quantity= quantity+1;

            }
            pdt.setCount(0);
            pdt.setQuantity(quantity);
            return  this.updateStockById(id,pdt);


    }




    public ApiResponse updateStockById(Long id , UpdateStockDTO updateStockDTO) {

//        Category category = getCategoryById(updateStockDTO.getCategory().getId());

//        if(category == null){
//            return new ApiResponse(200, CustomConstants.CAT_GETERROR,null);
//        }
        Optional<Product>findProduct = productsRepository.findById(id);
        Product product = findProduct.get();
//        product.setName(updateStockDTO.getName());
//        product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
//        product.setDescription(updateStockDTO.getDescription());
//        product.setPrice(updateStockDTO.getPrice());
        product.setQty(updateStockDTO.getQuantity());
//        product.setCostprice(updateStockDTO.getCostprice());
//        product.setCategory(category);
        productsRepository.save(product);
        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);

    }


    public ApiResponse searchProductByKeyword(String keyword) {
        List<Product> searchProductByKeyword = productsRepository.searchProductByKeyword(keyword);
        return new ApiResponse(Status.Status_Ok, "Successfully keyword Match From Product", searchProductByKeyword);
    }




    public Page<Product> joinAllProducts(Pageable pageable){
            return  productsRepository.findAll(pageable);
    }


}
