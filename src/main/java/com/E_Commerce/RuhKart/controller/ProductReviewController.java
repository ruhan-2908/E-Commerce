package com.E_Commerce.RuhKart.controller;


import com.E_Commerce.RuhKart.dto.ProductReviewDto;
import com.E_Commerce.RuhKart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products/reviews")
public class ProductReviewController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<?>  addReview(@RequestBody ProductReviewDto reviewDTO)
    {
        productService.addReview(reviewDTO);
    }
}
