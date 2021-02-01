package com.order.mgmt.ordermanagingservice.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TestController testController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }
}