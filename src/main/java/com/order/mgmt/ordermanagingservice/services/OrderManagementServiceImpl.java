package com.order.mgmt.ordermanagingservice.services;

import com.order.mgmt.ordermanagingservice.cache.OrderBookMap;
import com.order.mgmt.ordermanagingservice.exception.OrderMgmtException;
import com.order.mgmt.ordermanagingservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("OrderManagementService")
public class OrderManagementServiceImpl implements OrderManagementService {


    private OrderBookMap orderBookMap;

    public OrderManagementServiceImpl(){

    }

    @Autowired
    public void setOrderBookMap(OrderBookMap orderBookMap) {
        this.orderBookMap = orderBookMap;
    }

    @Override
    public OrderBook openOrderBook(Long instrumentId) {
        OrderBook book = new OrderBook(instrumentId);
        book.setOrderBookId(orderBookMap.nextOrderId());
        orderBookMap.addOrderBook(book);
        return book;
    }

    @Override
    public OrderBook closeOrderBook(Long orderBookId) throws OrderMgmtException {
           OrderBook book = orderBookMap.getOrderBookForId(orderBookId);
           book.setOrderStatus(OrderStatus.CLOSED);
           return book;
    }

    @Override
    public OrderBook addOrder(Long orderBookId, OrderType orderType, Long quantity, Double price)throws OrderMgmtException {
        OrderBook book = orderBookMap.getOrderBookForId(orderBookId);
        if(book.getOrderStatus().equals(OrderStatus.CLOSED))
        {
            throw new OrderMgmtException("err.002","invalid Add Operation");
        }
        Order order = new Order(book.getOrders().size()+1,
                quantity,new Date(),orderType,price );
        book.addOrder(order);
        return book;
    }

    @Override
    public OrderBook addExecution(Long orderBookId, Long quantity, Double executionPrice) throws OrderMgmtException {
        OrderBook book = orderBookMap.getOrderBookForId(orderBookId);
        if(book.getOrderStatus().equals(OrderStatus.OPEN))
        {
            throw new OrderMgmtException("err.003","invalid execution addition");
        }
        OrderExecution orderExecution  = new OrderExecution(quantity,executionPrice);
        book.addExecution(orderExecution);
        return book;
    }
}
