package com.E_Commerce.RuhKart.repository;

import com.E_Commerce.RuhKart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
