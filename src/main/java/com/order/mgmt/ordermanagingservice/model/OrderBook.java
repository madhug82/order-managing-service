package com.order.mgmt.ordermanagingservice.model;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {
    private Long orderBookId;
    private final Long instrumentId;
    private List<Order> orders = new ArrayList<Order>();
    private OrderStatus orderStatus;
    private List<OrderExecution> orderExecutions = new ArrayList<OrderExecution>();

    public OrderBook(Long orderBookId, Long instrumentId) {
        this.orderBookId = orderBookId;
        this.instrumentId = instrumentId;
        this.orders = orders;
    }

    public OrderBook(Long instrumentId){
        this.instrumentId=instrumentId;
        this.orderStatus=OrderStatus.OPEN;
    }

    public Long getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(Long orderBookId) {
        this.orderBookId = orderBookId;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void addExecution(OrderExecution orderExecution){
        this.orderExecutions.add(orderExecution);
    }

    public List<OrderExecution> getOrderExecutions() {
        return orderExecutions;
    }
}
