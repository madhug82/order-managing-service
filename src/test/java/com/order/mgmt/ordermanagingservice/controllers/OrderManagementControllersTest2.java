package com.order.mgmt.ordermanagingservice.controllers;

import com.order.mgmt.ordermanagingservice.cache.OrderBookMap;
import com.order.mgmt.ordermanagingservice.services.OrderManagementService;


import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
class OrderManagementControllersTest2 {

    private MockMvc mockMvc;

    @Mock
    OrderBookMap orderBookMap;

    @Mock
    private OrderManagementService orderManagementService;



     void setup() {
        final OrderManagementControllers orderManagementControllers = new OrderManagementControllers();
        orderManagementControllers.setOrderManagementService(orderManagementService);
        mockMvc = MockMvcBuilders.standaloneSetup(orderManagementControllers)
                .build();
    }


   @Test
    void testOpenOrderBook_PositiveCase() throws Exception {

       setup();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/orderbook/open/2")
                .accept(MediaType.APPLICATION_JSON))
                       .andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.jsonPath("$.orderStatus", Matchers.is("OPEN")))
                       .andExpect(MockMvcResultMatchers.jsonPath("$.instrumentId", Matchers.is("2")));


       mockMvc.perform(
               MockMvcRequestBuilders.post("/api/orderbook/open/1")
                       .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.orderStatus", Matchers.is("OPEN")))
               .andExpect(MockMvcResultMatchers.jsonPath("$.instrumentId", Matchers.is("1")));
    }


    @Test
    void testsCloseOrder() throws Exception {
        setup();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/orderbook/close/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.orderStatus", Matchers.is("OPEN")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.instrumentId", Matchers.is("2")));
    }

    @Test
    void testaddOrderToBook_forOpenOrder() throws Exception {

        setup();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/orderbook/addOrder/1/MARKET/10/100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.orderStatus", Matchers.is("OPEN")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.instrumentId", Matchers.is("2")));
    }

    @Test
    void testaddOrderToBook_forClosedOrder() throws Exception {

        setup();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/orderbook/addOrder/2/MARKET/10/100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());

    }


    }


