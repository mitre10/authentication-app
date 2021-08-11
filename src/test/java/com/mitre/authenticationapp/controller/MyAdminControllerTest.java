package com.mitre.authenticationapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitre.authenticationapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyAdminControllerTest {

    @Autowired
    MockMvc mvc;

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
    public void testAdmin_shouldReceiveUnauthorizedStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(value = "admin", roles = {"ADMIN"})
    public void testCreateUser_success() throws Exception {
        User user = new User("testUser", "testPass", true, "user@", 2);

        mvc.perform(post("/admin/create")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateUser_shouldReceiveUnauthorizedStatus_whenNoUserIsLogged() throws Exception {
        mvc.perform(get("/admin/create"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser("user")
    public void testCreateUser_shouldReceiveForbiddenStatus_withRoleUser() throws Exception {
        mvc.perform(get("/admin/created"))
                .andExpect(status().isForbidden());
    }
}
