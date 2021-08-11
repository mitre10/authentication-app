package com.mitre.authenticationapp.service;

import com.mitre.authenticationapp.model.User;
import com.mitre.authenticationapp.repository.MyUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyAdminService {
    Logger log = LoggerFactory.getLogger(MyAdminService.class);

    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        log.info("Saving user [{}] to database", newUser.getUsername());

        return userRepository.save(newUser);
    }
}
