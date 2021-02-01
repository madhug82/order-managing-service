package com.order.mgmt.ordermanagingservice.cache;

import com.order.mgmt.ordermanagingservice.exception.OrderMgmtException;
import com.order.mgmt.ordermanagingservice.model.OrderBook;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderBookMap {

    private static Long orderBookCounter=1L;
    private static Map<Long, OrderBook> orderBookCache = new ConcurrentHashMap<Long,OrderBook>();

    public OrderBookMap(){

    }

    public void addOrderBook(OrderBook orderBook){
        orderBookCache.put(orderBook.getOrderBookId(),orderBook);

    }

    public OrderBook getOrderBookForId(Long orderBookId) throws OrderMgmtException{
        try {
            return orderBookCache.get(orderBookId);
        }catch(Exception exception){
            throw new OrderMgmtException("err.01","Order Book Not found");
        }
    }

    public Long nextOrderId(){
        return orderBookCounter++;
    }



}
