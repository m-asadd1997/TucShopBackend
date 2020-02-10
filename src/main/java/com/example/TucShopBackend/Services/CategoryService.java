package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Value("${category.image.url}")
    String categoryImageUrl;

    public ApiResponse postCategory(CategoryDTO categoryDTO){

        Category categoryName = categoryRepository.findCategoriesByName(categoryDTO.getName());

        if(categoryName!= null){
            return new ApiResponse(409, CustomConstants.CAT_DUPLICATE,null);
        }
        else{

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

            if(saveCategoryImage(categoryDTO.getImage(),categoryDTO.getName(),unique)){

                Category category = new Category();
                category.setImage(categoryImageUrl+categoryDTO.getName()+"/"+unique+categoryDTO.getImage().getOriginalFilename());
                category.setName(categoryDTO.getName());
                categoryRepository.save(category);
                return new ApiResponse(200,CustomConstants.CAT_POSTED,category);
            }
        }

        return new ApiResponse(401,CustomConstants.CATIMAGE_ERROR,null);
    }

    public Boolean saveCategoryImage(MultipartFile file, String name, String unique){
        try {
            String UPLOADED_FOLDER_NEW = "E://TuckshopBackend_Main//TucShopBackend//serverFiles//"+name+"//";
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
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResponseEntity<InputStreamResource> getCategoryImage(String filename, String category) throws IOException{
        String filepath = "E://TuckshopBackend_Main/TucShopBackend//serverFiles//"+category+"//"+filename;
        File f = new File(filepath);
        Resource file = new UrlResource(f.toURI());
        return ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(
                        MediaType.parseMediaType("image/JPG"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    public Category getById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
           return category.get();
       }
       else {
           return new Category();
       }
    }

    public List <Category> getAll (){
        List <Category> categoryList =categoryRepository.findAll();
        return categoryList;
    }

    public  ApiResponse updateById (CategoryDTO categoryDTO, Long id) {

        Optional<Category> findCategory = categoryRepository.findById(id);
        Category category1 = findCategory.get();

        if (categoryDTO.getImage().getOriginalFilename().isEmpty()) {
            categoryDTO.setImage(null);
            return populateResponse(categoryDTO, category1);
        }
        if (category1.getImage()!= null && category1.getImage().equalsIgnoreCase(categoryDTO.getImage().getName())) {
            return populateResponse(categoryDTO, category1);
        }
        else {

            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

            if(saveCategoryImage(categoryDTO.getImage(), categoryDTO.getName(), unique)){
                category1.setName(categoryDTO.getName());
                category1.setImage(categoryImageUrl+categoryDTO.getName()+"/"+unique+categoryDTO.getImage().getOriginalFilename());
                categoryRepository.save(category1);
                return new ApiResponse(200, CustomConstants.CAT_UPDATE,category1);
            }
            return new ApiResponse(401, CustomConstants.CATIMAGE_ERROR,null);
        }
    }

    public  ApiResponse  deleteCategory (Long id){
     categoryRepository.deleteById(id);
    return  new ApiResponse (200, CustomConstants.CAT_DELETE, null, getAll());

    }


   public ApiResponse <Category> deleteAll (){
    categoryRepository.deleteAll();
     return new ApiResponse  (200, CustomConstants.CAT_DELETE, null);

    }

    private ApiResponse populateResponse(CategoryDTO categoryDTO, Category category1) {
        category1.setName(categoryDTO.getName());
        categoryRepository.save(category1);
        return new ApiResponse(200, CustomConstants.CAT_UPDATE, category1);
    }

}
