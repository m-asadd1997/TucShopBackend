package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
