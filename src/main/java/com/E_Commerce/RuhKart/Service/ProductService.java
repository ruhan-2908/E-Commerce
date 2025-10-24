package com.E_Commerce.RuhKart.Service;

import com.E_Commerce.RuhKart.entity.Product;
import com.E_Commerce.RuhKart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        List<Product> products =productRepository.findAll();
        return products;
    }
}
