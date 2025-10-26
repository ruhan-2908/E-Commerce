package com.E_Commerce.RuhKart.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name field is Required")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price field is Required")
    @PositiveOrZero(message = "Value must be zero or greater than zero")
    private Double price;

    @Column(nullable = true)
    private String description;


    private String category;

    private Double ratings = 0.0;

    @NotBlank(message = "Seller field is required")
    private String seller;

    @NotNull(message = "Stock field is required")
    private Integer stock;

    private Integer numberOfReviews = 0;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    public Product() {
        super();
    }

    public Product(Long id, String name, Integer stock, String seller, Double ratings, String description, String category, Double price) {
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

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
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
