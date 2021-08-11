package com.mitre.authenticationapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    private Logger log = LoggerFactory.getLogger(MyUserController.class);

    @GetMapping("/user")
    public ResponseEntity<String> user(Authentication authentication) {
        log.info("hitting /user route");

        return ResponseEntity.ok("Welcome " + authentication.getName());
    }
}
