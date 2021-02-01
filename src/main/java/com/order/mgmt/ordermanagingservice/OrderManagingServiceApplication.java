package com.order.mgmt.ordermanagingservice;

import com.order.mgmt.ordermanagingservice.cache.InstrumentMap;
import com.order.mgmt.ordermanagingservice.cache.OrderBookMap;
import com.order.mgmt.ordermanagingservice.model.FinancialInstrument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderManagingServiceApplication {

	@Bean
	public OrderBookMap getOrderBookMap(){
		return new OrderBookMap();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderManagingServiceApplication.class, args);

	}

}
