package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("/")
    public ApiResponse addCategory(@Valid  @RequestParam("image") MultipartFile image, CategoryDTO categoryDTO) {
        categoryDTO.setImage(image);
        return categoryService.postCategory(categoryDTO);

    }
    @GetMapping ("/{id}")
    public Category getById (@PathVariable("id") Long id ){
        return this.categoryService.getById(id);
    }


    @GetMapping ("/")
    public List<Category> getAll (CategoryDTO categoryDTO ){
        return categoryService.getAll();
    }

    @PutMapping("/{id}")
    public  ApiResponse updateById (@PathVariable ("id") Long id,@RequestParam("image") MultipartFile image, CategoryDTO categoryDTO){
        categoryDTO.setImage(image);
        return categoryService.updateById(categoryDTO, id);
    }

    @DeleteMapping ("/{id}")
    public ApiResponse deleteById (@PathVariable ("id") Long id){
        return  categoryService.deleteCategory(id);
    }

    @DeleteMapping ("/")
    public  ApiResponse<Category> deleteAll (CategoryDTO categoryDTO){
        return categoryService.deleteAll();
    }

    @RequestMapping(value = "/image/{category}/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename, @PathVariable("category") String category)
            throws IOException {
        return categoryService.getCategoryImage(filename,category);
    }

    @GetMapping("/subcategory/{id}")
    public ApiResponse getSubCategoriesById(@PathVariable("id") Long id){
            return categoryService.getSubCategoriesById(id);
    }
}
