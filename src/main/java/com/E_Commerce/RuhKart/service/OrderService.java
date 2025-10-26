package com.E_Commerce.RuhKart.service;


import com.E_Commerce.RuhKart.dto.CreateOrderRequest;
import com.E_Commerce.RuhKart.dto.OrderItemDto;
import com.E_Commerce.RuhKart.entity.Order;
import com.E_Commerce.RuhKart.entity.OrderItem;
import com.E_Commerce.RuhKart.entity.Product;
import com.E_Commerce.RuhKart.repository.OrderRepository;
import com.E_Commerce.RuhKart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    public Order createOrder(CreateOrderRequest orderRequest)
    {
        Order order = new Order();
        double totalItemsAmount = 0;
        for(OrderItemDto item : orderRequest.getOrderItems())
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setImage(item.getImage());
            orderItem.setPrice(item.getPrice());
            orderItem.setQuantity(item.getQuantity());

            Product  product = productRepository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product is Not Found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice() * item.getQuantity();
            order.getOrderItems().add(orderItem);
        }
        order.setStatus("PENDING");
        order.setTotalItemsAmount(totalItemsAmount);
        double taxAmount = 10;
        double totalAmount = totalItemsAmount + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
        order.setReferenceId(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
}
