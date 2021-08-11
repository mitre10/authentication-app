package com.mitre.authenticationapp.service;


import com.mitre.authenticationapp.model.User;
import com.mitre.authenticationapp.repository.MyUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MyAdminServiceTest {
    @Mock
    private MyUserRepository mockedUserRepository;

    @Mock
    private PasswordEncoder mockedPasswordEncoder;

    @InjectMocks
    private MyAdminService myAdminService;

    @Test
    public void testCreateUser() {
        User user = new User("testUser", "testPass", true, "user@", 2);

        myAdminService.createUser(user);

        verify(mockedUserRepository, times(1)).save(any());
    }
}
