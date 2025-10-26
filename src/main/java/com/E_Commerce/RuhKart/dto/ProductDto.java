package com.E_Commerce.RuhKart.dto;

import com.E_Commerce.RuhKart.entity.ProductImage;
import com.E_Commerce.RuhKart.entity.ProductReview;

import java.util.List;

public class ProductDto {


    private Long id;


    private String name;


    private Double price;


    private String description;


    private String category;

    private Double ratings = 0.0;


    private String seller;


    private Integer stock;

    private Integer numberOfReviews = 0;



    private List<ProductImage> images;


    private List<ProductReviewDto> reviews;

    public ProductDto() {
        super();
    }

    public ProductDto(Long id, String name, Integer stock, String seller, Double ratings, String description, String category, Double price) {
        super();
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.seller = seller;
        this.ratings = ratings;
        this.description = description;
        this.category= category;
        this.price = price;
    }

    public List<ProductReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewDto> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
}
