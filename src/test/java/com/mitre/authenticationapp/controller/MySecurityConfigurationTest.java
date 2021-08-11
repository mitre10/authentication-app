package com.mitre.authenticationapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MySecurityConfigurationTest {

    @Autowired
    MockMvc mvc;

    @Test
    @WithMockUser(value = "USER")
    public void testHome_success() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testHome_shouldReceiveUnauthorizedStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testHome_shouldReceiveUnauthorizedStatus_whenRandomEndpointIsAccessed() throws Exception {
        mvc.perform(get("/randomEndpoint"))
                .andExpect(status().isUnauthorized());
    }
}
