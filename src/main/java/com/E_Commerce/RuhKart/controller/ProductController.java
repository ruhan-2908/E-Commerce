package com.E_Commerce.RuhKart.controller;


import com.E_Commerce.RuhKart.Service.ProductService;
import com.E_Commerce.RuhKart.entity.Product;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
