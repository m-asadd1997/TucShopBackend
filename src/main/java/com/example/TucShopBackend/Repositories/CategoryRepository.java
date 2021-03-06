package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findCategoriesByName(String category);


    @Query(value ="select * from category where active =1" ,nativeQuery = true)
    List<Category> getAll();

//    public String findByName(String categoryName);



}
