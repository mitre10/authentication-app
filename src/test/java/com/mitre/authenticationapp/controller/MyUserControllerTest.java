package com.mitre.authenticationapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
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
    public void testUser_shouldReceiveForbiddenStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(value = "admin", roles = {"ADMIN"})
    public void testAdmin_success() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome admin"));
    }

    @Test
    @WithMockUser("user")
    public void testAdmin_shouldReceiveForbiddenStatus_withRoleUser() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testAdmin_shouldReceiveForbiddenStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isForbidden());
    }
}
