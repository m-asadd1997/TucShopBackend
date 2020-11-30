package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;

import com.example.TucShopBackend.Commons.Status;

import com.example.TucShopBackend.DTO.ProductsDTO;
import com.example.TucShopBackend.DTO.UpdateStockDTO;
import com.example.TucShopBackend.DTO.VariantsDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.ProductGallery;
import com.example.TucShopBackend.Repositories.CategoryRepository;
//import org.springframework.mock.web.MockMultipartFile;
import com.example.TucShopBackend.Repositories.ProductGalleryRepository;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import org.apache.commons.lang3.StringUtils;
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
//import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;

@Service
public class    ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductGalleryRepository productGalleryRepository;


    @Value("${product.image.url}")
    String productImageUrl;

    @Value("${product.defaultImage.url}")
    String productDeafultImageUrl;

    public ApiResponse getVariants(String keyword){
        List<VariantsDTO> variantsList = productsRepository.getVariants(keyword);
        return new ApiResponse(Status.Status_Ok,"Success",variantsList);
    }
    @Value("${spring.profiles.active}")
    String profile;

    //serverfile.path
//    @Value("${serverfile.path}")
//    String serverFilePath;

    @Autowired
    private CloudinaryService cloudinaryService;

    public ApiResponse saveProducts(MultipartFile[] productImages,ProductsDTO productsDTO){

        if (checkProductBarcodeExsist(productsDTO,null)){
            return new ApiResponse(Status.Status_DUPLICATE, "Barcode already exist", null);
        }

       List< Product> productName = productsRepository.findByName(productsDTO.getName(), productsDTO.getVariants());
//
        Boolean flag = false;
        Boolean duplicateCheck = false;

        for(int i = 0; i< productName.size();   i++){

                if(productName.get(i).getVariants().equals(productsDTO.getVariants()) ){
                flag = true;
            }
                if(productName.get(i).getActive()){
                    duplicateCheck=true;
                }
        }
        String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        Category category = getCategoryById(productsDTO.getCategory().getId());

        if(productName == null ||!flag) {

            if(category == null){
                return new ApiResponse(Status.Status_ERROR, CustomConstants.CAT_GETERROR,null);
            }
                switch (profile){
                    case CustomConstants.DEV:

                        if(productsDTO.getImage()==null){
                            Product product = new Product();
                            product.setImage(productDeafultImageUrl);
                            product.setCategory(category);
                            product.setDescription(productsDTO.getDescription());
                            product.setPrice(productsDTO.getPrice());
                            if(productsDTO.getQuantity()==0)
                            {
                                product.setInfiniteQuantity(true);
                                product.setQty(1000000);

                            }
                            else
                            {
                                product.setInfiniteQuantity(false);
                                product.setQty(productsDTO.getQuantity());
                            }
                            product.setCostprice(productsDTO.getCostprice());
                            product.setName(productsDTO.getName());
                            product.setDate1(productsDTO.getDate1());
                            product.setVariants(productsDTO.getVariants());
                            product.setActive(true);
                            product.setOnlineProduct(productsDTO.getOnlineProduct());
                            product.setSku(productsDTO.getSku());
                            productsRepository.save(product);

                            return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);


                        }else if(saveProductImage(productsDTO.getImage(),category.getName(),unique)){


                            Product product = new Product();
                            product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
                            product.setCategory(category);
                            product.setDescription(productsDTO.getDescription());
                            product.setPrice(productsDTO.getPrice());
                            if(productsDTO.getQuantity()==0)
                            {
                                product.setInfiniteQuantity(true);
                                product.setQty(1000000);

                            }
                            else
                            {
                                product.setInfiniteQuantity(false);
                                product.setQty(productsDTO.getQuantity());
                            }
                            product.setCostprice(productsDTO.getCostprice());
                            product.setName(productsDTO.getName());
                            product.setDate1(productsDTO.getDate1());
                            product.setVariants(productsDTO.getVariants());
                            product.setActive(true);
                            product.setOnlineProduct(productsDTO.getOnlineProduct());
                            product.setSku(productsDTO.getSku());
                            Product productObj = productsRepository.save(product);
                            if(productObj != null && productsDTO.getOnlineProduct().equals("yes")){
                                Arrays.asList(productImages).stream().forEach(file->{
                                    ProductGallery productGallery = new ProductGallery();
                                    String uniqueForGallery = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
                                    if(saveProductImage(file,category.getName(),uniqueForGallery)){
                                        productGallery.setImage(productImageUrl+category.getName()+"/"+productObj.getName()+"/"+uniqueForGallery+file.getOriginalFilename());
                                        productGallery.setProduct(productObj);
                                        productGalleryRepository.save(productGallery);
                                    }
                                });
                                return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, productObj);
                            }
                            return new ApiResponse(Status.Status_Ok, "Product saved without gallery images", productObj);

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
                            if(productsDTO.getQuantity()==0)
                            {
                                product.setInfiniteQuantity(true);
                                product.setQty(1000000);

                            }
                            else
                            {
                                product.setInfiniteQuantity(false);
                                product.setQty(productsDTO.getQuantity());
                            }
                            product.setCostprice(productsDTO.getCostprice());
                            product.setName(productsDTO.getName());
                            product.setVariants(productsDTO.getVariants());
                            product.setSku(productsDTO.getSku());
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
                if(productsDTO.getQuantity()==0)
                {
                    product.setInfiniteQuantity(true);
                    product.setQty(1000000);

                }
                else
                {
                    product.setInfiniteQuantity(false);
                    product.setQty(productsDTO.getQuantity());
                }
                product.setCostprice(productsDTO.getCostprice());
                product.setName(productsDTO.getName());
                product.setVariants(productsDTO.getVariants());
                product.setSku(productsDTO.getSku());
                productsRepository.save(product);
                return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);
            }
        }


        else{
            if(!duplicateCheck)
            {
                Product product = new Product();
                product.setImage(productImageUrl+category.getName()+"/"+productsDTO.getName()+"/"+unique+productsDTO.getImage().getOriginalFilename());
                product.setCategory(category);
                product.setDescription(productsDTO.getDescription());
                product.setPrice(productsDTO.getPrice());
                if(productsDTO.getQuantity()==0)
                {
                    product.setInfiniteQuantity(true);
                    product.setQty(1000000);

                }
                else
                {
                    product.setInfiniteQuantity(false);
                    product.setQty(productsDTO.getQuantity());
                }
                product.setCostprice(productsDTO.getCostprice());
                product.setName(productsDTO.getName());
                product.setDate1(productsDTO.getDate1());
                product.setVariants(productsDTO.getVariants());
                product.setActive(true);
                product.setSku(productsDTO.getSku());
                productsRepository.save(product);
                return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_POSTED, product);
            }
            return new ApiResponse(Status.Status_DUPLICATE, CustomConstants.PROD_DUPLICATE, null);
        }

        return new ApiResponse(Status.Status_ERROR,CustomConstants.PRODIMAGE_ERROR,null);
    }

    private Category getCategoryById(Long id) {
        Optional<Category> category =categoryRepository.findById(id);
        return category.isPresent()? category.get() : null;
    }

    public Boolean saveProductImage(MultipartFile file, String name, String unique  ){

        if(file == null){
            return  true;
        }

        try{

        String UPLOADED_FOLDER_NEW = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+name+"//"+"products"+"//";

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
        String filepath = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+category+"//products//"+filename;
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
//        return productsRepository.findAll();

        return productsRepository.getAll();
    }

    public Product getProductById(Long id){
        Optional<Product> product =  productsRepository.findById(id);
        if(product.isPresent()&&product.get().getActive()){
            return product.get();
        }
        else{
            return new Product();
        }
    }
    public ApiResponse deleteAll(){
//        productsRepository.deleteAll();
        List<Product> products= productsRepository.findAll();
        if(products.size()>0) {
            for (Product pdt : products) {
                pdt.setActive(false);
                productsRepository.save(pdt);

            }
        }
        return new ApiResponse(Status.Status_Ok,CustomConstants.PROD_DELETE,null  );
    }
    public  ApiResponse deleteProductById(Long id) {

       Optional<Product> products = productsRepository.findById(id);
       if(products.isPresent()){
//           String imgPath = products.get().getImage();
//           String[] path = imgPath.split("/");
//           String path1="";
//           for(Integer i = 6; i < path.length ; i++){
//               if(i == path.length-1){
//                   path1 +=  path[i];
//               }
//               else if (i==7){
//
//                   path1+= "products//";
//               }
//               else{
//                   path1 +=  path[i]+"//";
//               }
//           }
//           if (deleteProductImage(path1)){

//              productsRepository.deleteById(id);

               products.get().setActive(false);
               productsRepository.save(products.get());
              return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_DELETE, null);

//          }
//          else{
//              return new ApiResponse(Status.Status_ERROR, CustomConstants.PRODIMAGE_ERROR, null);
//          }
       }
       return new ApiResponse(Status.Status_Ok, CustomConstants.PROD_DELETE, null);
    }

    public ApiResponse updateById(Long id ,MultipartFile[] productImages,ProductsDTO productsDTO) {
        if (checkProductBarcodeExsist(productsDTO,id)){
            return new ApiResponse(Status.Status_DUPLICATE, "Barcode already exist", null);
        }


        Category category = getCategoryById(productsDTO.getCategory().getId());

        if(category == null){
            return new ApiResponse(200, CustomConstants.CAT_GETERROR,null);
        }

        Optional<Product>findProduct = productsRepository.findById(id);
        Product product = findProduct.get();
        List<ProductGallery> productGalleryImages = productGalleryRepository.findByProductId(id);

        if(productsDTO.getImage()!=null && productsDTO.getImage().getOriginalFilename().isEmpty()) {
            product.setImage(null);
            return populateResponse(productsDTO, category, product);
        }

         if(product.getImage()!=null && productsDTO.getImage()!=null && product.getImage().equalsIgnoreCase(productsDTO.getImage().getName())){

             return populateResponse(productsDTO, category, product);
         }
         else{
            switch (profile){
                case CustomConstants.DEV:
                    String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());


                    if (saveProductImage(productsDTO.getImage(), category.getName(), unique)) {

                        product.setName(productsDTO.getName());
                        if(productsDTO.getImage()!=null) {
                            product.setImage(productImageUrl + category.getName() + "/" + productsDTO.getName() + "/" + unique + productsDTO.getImage().getOriginalFilename());
                        }else{
                            product.setImage(productDeafultImageUrl);
                        }
                        product.setDescription(productsDTO.getDescription());
                        product.setPrice(productsDTO.getPrice());
                        product.setQty(productsDTO.getQuantity());
                        product.setCostprice(productsDTO.getCostprice());
                        product.setCategory(category);
                        product.setVariants(productsDTO.getVariants());
                        product.setSku(productsDTO.getSku());
                        product.setOnlineProduct(productsDTO.getOnlineProduct());
                        Product productObj = productsRepository.save(product);
                        if(!productGalleryImages.isEmpty()){
                            productGalleryImages.forEach(imgObj -> {
                                deleteGalleryImageById(imgObj.getId());
                            });
                            if(productObj != null && productsDTO.getOnlineProduct().equals("yes")) {
                                Arrays.asList(productImages).stream().forEach(file -> {
                                    ProductGallery productGallery = new ProductGallery();
                                    String uniqueForGallery = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
                                    if (saveProductImage(file, category.getName(), uniqueForGallery)) {
                                        productGallery.setImage(productImageUrl + category.getName() + "/" + productObj.getName() + "/" + uniqueForGallery + file.getOriginalFilename());
                                        productGallery.setProduct(productObj);
                                        productGalleryRepository.save(productGallery);
                                    }
                                });
                            }
                            return new ApiResponse(200, CustomConstants.PROD_UPDATE + " with gallery images", productObj);
                        }
                        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);
                    }
                    break;

                case CustomConstants.PROD:
                    try {
                        Map map =  cloudinaryService.upload(productsDTO.getImage());
                        product.setName(productsDTO.getName());
                        if(productsDTO.getImage()!=null)
                        product.setImage(map.get("url").toString());
                        product.setDescription(productsDTO.getDescription());
                        product.setPrice(productsDTO.getPrice());
                        product.setQty(productsDTO.getQuantity());
                        product.setCostprice(productsDTO.getCostprice());
                        product.setCategory(category);
                        product.setSku(productsDTO.getSku());
                        productsRepository.save(product);

                        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }


        return new ApiResponse(401,CustomConstants.PRODIMAGE_ERROR,null);

        }

    }

    private boolean checkProductBarcodeExsist(ProductsDTO productsDTO,Long id) {
        if(StringUtils.isNotBlank(productsDTO.getSku())){
            if(id !=null){
                Product barCodeExist = productsRepository.getDistinctProductByBarCode(productsDTO.getSku(),id);
                if(barCodeExist!=null){
                    return true;
                }
            }else{
                Product barCodeExist = productsRepository.getProductByBarCode(productsDTO.getSku());
                if(barCodeExist!=null){
                    return true;
                }
            }



        }
        return false;
    }

    private ApiResponse populateResponse(ProductsDTO productsDTO, Category category, Product product) {
        product.setName(productsDTO.getName());
        product.setDescription(productsDTO.getDescription());
        product.setPrice(productsDTO.getPrice());
        product.setQty(productsDTO.getQuantity());
        product.setCostprice(productsDTO.getCostprice());
        product.setCategory(category);
        product.setSku(productsDTO.getSku());
        productsRepository.save(product);
        return new ApiResponse(200, CustomConstants.PROD_UPDATE, product);

    }
        int count=0;
    public ApiResponse AddQty(Long id,UpdateStockDTO pdt ){
        Product pdt1 = getProductById(id);
       boolean isInfinite= pdt1.isInfiniteQuantity();
       if(!isInfinite) {
           double quantity = pdt1.getQty();
           if (quantity - 1 < 0) {

               pdt.setQuantity(0.0);
               return this.updateStockById(id, pdt);
           } else {
//            pdt1.setQty(quantity-1);
               pdt.setCount((pdt.getCount() + 1));
               pdt.setQuantity(quantity - 1);
               return this.updateStockById(id, pdt);

           }
       }
       else return new ApiResponse(Status.Status_Ok,"Updated",pdt1);
    }


    public ApiResponse MinusQty(Long id , UpdateStockDTO pdt){
        Product pdt1 = getProductById(id);

        double quantity=pdt1.getQty();
        boolean isInfinite= pdt1.isInfiniteQuantity();
        if(!isInfinite) {
            if (pdt.getCount() > 0) {

                pdt.setQuantity(quantity + 1);
                pdt.setCount(pdt.getCount() - 1);
                return this.updateStockById(id, pdt);
            } else {
                pdt.setQuantity(quantity);

                return this.updateStockById(id, pdt);
            }
        }
        else return new ApiResponse(Status.Status_Ok,"Updated",pdt1);
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
            return  productsRepository.findByCondition(pageable);
    }

    public ApiResponse deleteGalleryImageById(Long id) {

        Optional<ProductGallery> productGallery = productGalleryRepository.findById(id);
        if (productGallery.isPresent()) {
            String imgPath = productGallery.get().getImage();
            String path1 = getImagePath(imgPath);
            if (deleteProductImage(path1)) {

                productGalleryRepository.deleteById(id);

                return new ApiResponse(200, "Picture deleted", null);

            } else {
                return new ApiResponse(400, "Error deleting Picture", null);
            }
        }
        return new ApiResponse(400, "Picture not found", null);
    }

    public Boolean deleteProductImage(String path) {
        String filepath = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+path;
        File f = new File(filepath);

        try {

            if(f.delete()) {
                System.out.println(f.getName() + " is deleted!");

            } else {
                System.out.println("Delete operation is failed.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed to Delete image !!");
        }

        return  true;
    }

    public String getImagePath(String dbPath) {

        String[] path = dbPath.split("/");
        String path1 = "";
        for (Integer i = 6; i < path.length; i++) {
            if (i == path.length - 1) {
                path1 += path[i];
            } else if (i == 7) {

                path1 += "products//";
            } else {
                path1 += path[i] + "//";
            }
        }
        return path1;
    }

    public ApiResponse getProductByBarCode(String code){
      Product product = productsRepository.getProductByBarCode(code);
        if(product!=null){

            if(product.isInfiniteQuantity()){
                return new ApiResponse(Status.Status_Ok,"Success",product);
            }

            if(product.getQty()>0 ){
            product.setQty(product.getQty()-1);
            Product p = productsRepository.save(product);
                return new ApiResponse(Status.Status_Ok,"Success",p);
            }else {
                return new ApiResponse(Status.Status_ERROR,"Out of Stock",null);
            }

        }else{
            return new ApiResponse(Status.Status_ERROR,"Product not in Database",null);
        }



    }

    public ApiResponse getOnlineProductsOnHomePage(){
        List<Object> onlineProducts = productsRepository.getOnlineProductsForHomePage();
        if(!onlineProducts.isEmpty()){
            return new ApiResponse(Status.Status_Ok,"Online products found",onlineProducts);
        }
        else{
            return new ApiResponse(Status.Status_ERROR,"Online products not found",null);
        }
    }

    public ApiResponse getOnlineProductById(Long id){
        List<Product> onlineProducts = productsRepository.getOnlineProductById(id);
        if(!onlineProducts.isEmpty()){
            return new ApiResponse(Status.Status_Ok,"Online product found",onlineProducts);
        }else{
            return new ApiResponse(Status.Status_ERROR,"Online product not found",null);
        }
    }

    public ApiResponse getOnlineProductByMinAndMaxPrice(double minPrice,double maxPrice){
        List<Object> onlineProducts = productsRepository.getFilteredOnlineProductsForHomePage(minPrice,maxPrice);
        if(!onlineProducts.isEmpty()){
            return new ApiResponse(Status.Status_Ok,"Online products by filtered price found",onlineProducts);
        }else{
            return new ApiResponse(Status.Status_ERROR,"Online products by filtered price not found",null);
        }
    }

    public ApiResponse sortedOnlineProductby(String sortedValue){
        List<Object> onlineProducts = new ArrayList<>();
        if(sortedValue.equals("asc")){
            onlineProducts = productsRepository.sortOnlineProductsByAscending();
        }
        else if(sortedValue.equals("desc")){
            onlineProducts = productsRepository.sortOnlineProductsByDescending();
        }
        else if(sortedValue.equals("new")){
            onlineProducts = productsRepository.sortOnlineProductsByNewness();
        }
        if(!onlineProducts.isEmpty()){
            return new ApiResponse(Status.Status_Ok,"Online products by filtered price found",onlineProducts);
        }else{
            return new ApiResponse(Status.Status_ERROR,"Online products by filtered price not found",null);
        }
    }
}
