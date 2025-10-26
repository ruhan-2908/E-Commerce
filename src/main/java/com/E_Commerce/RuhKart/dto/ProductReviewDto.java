package com.E_Commerce.RuhKart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductReviewDto {

    @NotNull(message = "Product Id Field is Required")
    private Long productId;
    @NotBlank(message = "Comment cannot be blank.")
    private String comment;
    @NotNull(message = "Rating field is required")
    private Double rating;

    public ProductReviewDto() {
        super();
    }

    public ProductReviewDto(Long productId, String comment, Double rating) {
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
