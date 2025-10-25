package com.E_Commerce.RuhKart.Service;

import com.E_Commerce.RuhKart.entity.Product;
import com.E_Commerce.RuhKart.repository.ProductRepository;
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
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getAllProducts(int page , int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> products =productRepository.findAll(pageable);
        Map<String,Object> response= new HashMap<>();
        response.put("products",products.getContent());
        response.put("totalProducts",products.getTotalElements());
        return response;
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
            spec = (spec == null) ? ProductSpecification.
        }
        if (spec == null) {
            return productRepository.findAll();
        }



        return productRepository.findAll(spec);
    }
}

