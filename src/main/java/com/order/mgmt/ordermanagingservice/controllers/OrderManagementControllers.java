package com.order.mgmt.ordermanagingservice.controllers;

import com.order.mgmt.ordermanagingservice.exception.OrderMgmtException;
import com.order.mgmt.ordermanagingservice.model.OrderBook;
import com.order.mgmt.ordermanagingservice.model.OrderType;
import com.order.mgmt.ordermanagingservice.services.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderbook")
public class OrderManagementControllers {


 private OrderManagementService orderManagementService;

 @Autowired
 public void setOrderManagementService(OrderManagementService orderManagementService){
     this.orderManagementService=orderManagementService;
 }

 @PostMapping ("/open/{instrumentId}")
 public OrderBook openOrder(@PathVariable("instrumentId") Long instrumentId){
    return orderManagementService.openOrderBook(instrumentId);
 }

    @PutMapping ("/close/{orderBookId}")
    public OrderBook closeOrder(@PathVariable("orderBookId") Long orderBookId) throws OrderMgmtException {
        return orderManagementService.closeOrderBook(orderBookId);
    }

    @PutMapping ("/addOrder/{orderBookId}/{orderType}/{quantity}/{price}")
    public OrderBook addOrderToBook(@PathVariable("orderBookId") Long orderBookId,@PathVariable("orderType") OrderType orderType,
                                    @PathVariable("quantity") Long quantity,@PathVariable("price") Double price ) throws OrderMgmtException {
        return orderManagementService.addOrder(orderBookId,orderType,quantity,price);
    }

    @PutMapping ("/addExecution/{orderBookId}/{quantity}/{price}")
    public OrderBook addExecutionToBook(@PathVariable("orderBookId") Long orderBookId,@PathVariable("quantity") Long quantity,
                                        @PathVariable("price") Double price ) throws OrderMgmtException {
        return orderManagementService.addExecution(orderBookId,quantity,price);
    }
}
