package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("/")
    public ApiResponse addCategory(@RequestParam("image") MultipartFile image, CategoryDTO categoryDTO) {
        categoryDTO.setImage(image);
        return categoryService.postCategory(categoryDTO);
    }

    @RequestMapping(value = "/image/{category}/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename, @PathVariable("category") String category)
            throws IOException {
        return categoryService.getCategoryImage(filename,category);
    }
}
