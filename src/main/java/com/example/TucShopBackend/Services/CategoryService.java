package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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

    public ApiResponse postCategory(CategoryDTO categoryDTO){
        Category categoryName = categoryRepository.findCategoriesByName(categoryDTO.getName());
        if(categoryName!= null){
            return new ApiResponse(Status.Status_DUPLICATE, CustomConstants.CAT_DUPLICATE,null);
        }
        else{
            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            if(saveCategoryImage(categoryDTO.getImage(),categoryDTO.getName(),unique)){
                Category category = new Category();
                category.setImage("http://localhost:8080/"+categoryDTO.getName()+"/"+unique+categoryDTO.getImage().getOriginalFilename());
                category.setName(categoryDTO.getName());
                categoryRepository.save(category);
                return new ApiResponse(Status.Status_Ok,CustomConstants.CAT_POSTED,category);
            }
        }

        return new ApiResponse(Status.Status_ERROR,CustomConstants.CATIMAGE_ERROR,null);
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
          //  file.getsl
            BufferedImage inputImage = ImageIO.read(file.getInputStream());

            BufferedImage resized = resize(inputImage, 100, 100);
//            BufferedImage outputImage = new BufferedImage(100,
//                    100, inputImage.getType());

            String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            ImageIO.write(resized, format, new File(UPLOADED_FOLDER_NEW + unique+ file.getOriginalFilename()));
//            byte[] bytes = outputImage.get//file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER_NEW + unique+ file.getOriginalFilename());
//            Files.write(path, bytes);
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

    public  ApiResponse updateById (CategoryDTO categoryDTO, Long id){
        Optional <Category> category = categoryRepository.findById(id);
        Category category1 = category.get();
        category1.setName(categoryDTO.getName());
//        category1.setImage(categoryDTO.getImage());
        categoryRepository.save(category1);
        return new ApiResponse(Status.Status_Ok, CustomConstants.CAT_UPDATE, category1);
    }

   public  ApiResponse  deleteCategory (Long id){
     categoryRepository.deleteById(id);

    return  new ApiResponse (Status.Status_Ok, CustomConstants.CAT_DELETE, null, getAll());

    }


   public ApiResponse <Category> deleteAll (){


    categoryRepository.deleteAll();

     return new ApiResponse  (Status.Status_Ok, CustomConstants.CAT_DELETE, null);

    }

    private BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}
