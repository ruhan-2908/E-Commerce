package com.E_Commerce.RuhKart.service;

import com.E_Commerce.RuhKart.dto.ProductDto;
import com.E_Commerce.RuhKart.dto.ProductReviewDto;
import com.E_Commerce.RuhKart.entity.Product;
import com.E_Commerce.RuhKart.entity.ProductReview;
import com.E_Commerce.RuhKart.repository.ProductRepository;
import com.E_Commerce.RuhKart.repository.ProductReviewRepository;
import com.E_Commerce.RuhKart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public Map<String, Object> getAllProducts(int page , int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> products =productRepository.findAll(pageable);
        List<ProductDto> productDtos = products.stream().map(this::convertTODto).collect(Collectors.toList());
        Map<String,Object> response= new HashMap<>();
        response.put("products",productDtos);
        response.put("totalProducts",products.getTotalElements());
        return response;
    }
    public ProductDto convertTODto(Product product)
    {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCategory(product.getCategory());
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setRatings(product.getRatings());
        productDto.setReviews(product.getReviews());
        productDto.setNumberOfReviews(product.getNumberOfReviews());

//        productDto.setReviews(product.getReviews());
        List<ProductReviewDto> reviewDtos = product.getReviews().stream().map(review -> {
            ProductReviewDto reviewDto = new ProductReviewDto();
            reviewDto.setProductId(review.getId());
            reviewDto.setComment(review.getComment());
            reviewDto.setRating(review.getRating());
            return reviewDto;
        }).collect(Collectors.toList());
        productDto.setReviews(reviewDtos);
    }
    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with the id " + id));
    }

    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String keyword,Double ratings)
    {
        Specification<Product> spec = null;
        if (category != null && !category.isEmpty()) {
            spec = (spec == null) ? ProductSpecification.hasCategory(category) : spec.and(ProductSpecification.hasCategory(category));
        }

        if (minPrice != null) {
            spec = (spec == null) ? ProductSpecification.priceBetween(minPrice,Double.MAX_VALUE) : spec.and(ProductSpecification.priceBetween(minPrice,Double.MAX_VALUE));

        }

        if (maxPrice != null) {
            spec = (spec == null) ? ProductSpecification.priceBetween(0.0,maxPrice) : spec.and(ProductSpecification.priceBetween(0.0,maxPrice));
        }

        if (keyword != null && !keyword.isEmpty()) {
            spec = (spec == null) ? ProductSpecification.hasNameorDescriptionLike(keyword) : spec.and(ProductSpecification.hasNameorDescriptionLike(keyword));
        }

        if(ratings != null )
        {
            spec = (spec == null) ? ProductSpecification.ratingGreaterThan(ratings) : spec.and(ProductSpecification.ratingGreaterThan(ratings));
        }
        if (spec == null) {
            return productRepository.findAll();
        }



        return productRepository.findAll(spec);
    }

    public void addReview(ProductReviewDto reviewDTO) {

        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductReview review = new ProductReview();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setProduct(product);
        productReviewRepository.save(review);
    }
}

