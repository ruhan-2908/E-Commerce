package com.E_Commerce.RuhKart.dto;
import java.util.List;

public class CreateOrderRequest {
    private List<OrderItemDto> orderItems;

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
