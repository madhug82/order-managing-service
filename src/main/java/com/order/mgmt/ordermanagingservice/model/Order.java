package com.order.mgmt.ordermanagingservice.model;

import java.util.Date;

public final class Order {

    private final Integer orderId;
    private final Long quantity;
    private final Date entryDate;
    private final OrderType orderType;
    private final Double orderPrice;



    public Order(Integer orderId, Long quantity, Date entryDate, OrderType orderType,Double orderPrice) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.entryDate = entryDate;
        this.orderType = orderType;
        this.orderPrice=orderPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }
}
