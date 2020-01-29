package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse postCategory(CategoryDTO categoryDTO){
        Category categoryName;
        categoryName = categoryRepository.findCategoriesByName(categoryDTO.getName());
        if(categoryName!= null){
            return new ApiResponse(409,"Duplicate",null);
        }
        else{
            Category category = new Category();
            category.setImage(categoryDTO.getImage());
            category.setName(categoryDTO.getName());
            categoryRepository.save(category);
            return new ApiResponse(200,"Success",category);
        }
    }

    public Category getById(Long id){
        Optional<Category> category=categoryRepository.findById(id);

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
        category1.setImage(categoryDTO.getImage());
        categoryRepository.save(category1);
        return new ApiResponse(200, "Success", category1);
    }

   public  ApiResponse  deleteCategory (Long id){
     categoryRepository.deleteById(id);

    return  new ApiResponse (200, "Delete Success", null, getAll());
    }


   public ApiResponse <Category> deleteAll (){

    categoryRepository.deleteAll();

     return new ApiResponse  (200, "Deleted", null);
    }
}
