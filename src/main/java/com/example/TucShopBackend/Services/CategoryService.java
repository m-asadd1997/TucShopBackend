package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}
