package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.ReviewDTO;
import com.example.TucShopBackend.Models.Review;
import com.example.TucShopBackend.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public ApiResponse saveReviews(ReviewDTO reviewDTO){
        Review review = new Review(reviewDTO.getName(),reviewDTO.getEmail(),reviewDTO.getComment(),reviewDTO.getNoOfStars(),reviewDTO.getProduct());
        return new ApiResponse(200,"Review Saved",reviewRepository.save(review));
    }
}
