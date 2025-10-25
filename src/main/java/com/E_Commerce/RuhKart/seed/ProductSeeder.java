package com.E_Commerce.RuhKart.seed;

import com.E_Commerce.RuhKart.entity.Product;
import com.E_Commerce.RuhKart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0)
        {
            List<Product> demoproducts = List.of(
                    new Product(null,"Apple iPhone 15",5,"Amazon",4.8,"SmartPhone with a16 chip",799.0),
                    new Product(null, "Samsung Galaxy S23", 8, "Samsung Store", 4.7, "Flagship Android phone with Snapdragon 8 Gen 2", 749.0),
                    new Product(null, "Sony WH-1000XM5", 15, "Croma", 4.9, "Premium noise-cancelling wireless headphones", 399.0),
                    new Product(null, "Dell XPS 13 Laptop", 3, "Dell Official", 4.6, "13-inch ultrabook with Intel i7 and 16GB RAM", 1199.0),
                    new Product(null, "Apple MacBook Air M2", 4, "Apple Store", 4.9, "Lightweight laptop with M2 chip and Retina display", 1249.0),
                    new Product(null, "Logitech MX Master 3S Mouse", 20, "Flipkart", 4.8, "Ergonomic wireless mouse with fast scrolling", 99.0),
                    new Product(null, "Nike Air Zoom Pegasus 40", 10, "Nike Official", 4.7, "Comfortable running shoes with responsive cushioning", 129.0),
                    new Product(null, "Canon EOS R50 Camera", 6, "Canon Store", 4.5, "Mirrorless camera with 4K video and Dual Pixel AF", 899.0),
                    new Product(null, "Samsung 55-inch QLED TV", 2, "Reliance Digital", 4.8, "4K Smart TV with Quantum HDR and Alexa built-in", 999.0),
                    new Product(null, "Apple Watch Series 9", 7, "Apple Store", 4.9, "Smartwatch with advanced health tracking and OLED display", 449.0)
            );

            productRepository.saveAll(demoproducts);
            System.out.println("Seeded Demo Products");
        }
        else
        {
            System.out.println("Products already exits, skipping seed.......");
        }
    }
}
