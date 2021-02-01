package com.order.mgmt.ordermanagingservice.model;

public class OrderExecution {

    private Long quantity;
    private Double price;

    public OrderExecution(Long quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
