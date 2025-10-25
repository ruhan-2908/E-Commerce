package com.E_Commerce.RuhKart.controller;


import com.E_Commerce.RuhKart.Service.ProductService;
import com.E_Commerce.RuhKart.entity.Product;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public Map<String,Object> getAllProducts(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "5") int size)
    {;
        return productService.getAllProducts(page,size);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }
}
