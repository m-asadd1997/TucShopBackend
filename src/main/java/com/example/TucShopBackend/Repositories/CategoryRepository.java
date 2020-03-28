package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findCategoriesByName(String category);

//    public String findByName(String categoryName);



}
