package com.mitre.authenticationapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyUserControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @WithMockUser("user")
    public void testUser_success() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome user"));
    }

    @Test
    @WithMockUser(value = "admin", roles = {"ADMIN"})
    public void testUser_success_withRoleAdmin() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome admin"));
    }

    @Test
    public void testUser_shouldReceiveUnauthorizedStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isUnauthorized());
    }
}
