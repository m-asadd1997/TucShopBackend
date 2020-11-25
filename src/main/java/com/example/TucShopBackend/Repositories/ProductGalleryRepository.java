package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.ProductGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductGalleryRepository extends JpaRepository<ProductGallery,Long> {

    public List<ProductGallery> findByProductId(Long id);
}
