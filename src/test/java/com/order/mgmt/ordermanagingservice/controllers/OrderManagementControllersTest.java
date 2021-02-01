package com.order.mgmt.ordermanagingservice.controllers;

import com.order.mgmt.ordermanagingservice.services.OrderManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class OrderManagementControllersTest {

    private MockMvc mockMvc;

    @InjectMocks
    private OrderManagementControllers orderManagementControllers;

    @Mock
    private OrderManagementService orderManagementService;

   /* @BeforeEach
  void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderManagementControllers)
                .build();
    }

    @Test
    void openOrder() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/open/2")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }*/
}

   /* @Test
    void closeOrder() {
    }

    @Test
    void addOrderToBook() {
    }

    @Test
    void addExecutionToBook() {
    }*/
