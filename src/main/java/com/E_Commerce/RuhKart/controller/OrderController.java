package com.E_Commerce.RuhKart.controller;


import com.E_Commerce.RuhKart.dto.CreateOrderRequest;
import com.E_Commerce.RuhKart.dto.OrderCreated;
import com.E_Commerce.RuhKart.entity.Order;
import com.E_Commerce.RuhKart.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest)
    {
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }
    @GetMapping("/{referenceId}")
    public ResponseEntity<?> getOrder(@PathVariable String referenceId)
    {
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }
}
