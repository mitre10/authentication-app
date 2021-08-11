package com.mitre.authenticationapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MySimpleControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testHome_success() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome"));
    }

    @Test
    public void testHome_shouldReceiveNotFoundStatus_whenRandomEndpointIsAccessed() throws Exception {
        mvc.perform(get("/randomEndpoint"))
                .andExpect(status().isNotFound());
    }
}
