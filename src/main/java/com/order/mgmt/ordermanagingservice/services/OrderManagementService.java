package com.order.mgmt.ordermanagingservice.services;

import com.order.mgmt.ordermanagingservice.exception.OrderMgmtException;
import com.order.mgmt.ordermanagingservice.model.OrderBook;
import com.order.mgmt.ordermanagingservice.model.OrderType;

public interface OrderManagementService {

    OrderBook openOrderBook(Long instrumentId);
    OrderBook closeOrderBook(Long orderBookId) throws OrderMgmtException;
    OrderBook addOrder(Long orderBookId, OrderType orderType, Long orderQuantity, Double orderPrice) throws OrderMgmtException;
    OrderBook addExecution(Long orderBookId,Long quantity, Double executionPrice) throws OrderMgmtException;



}
