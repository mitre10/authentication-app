package com.mitre.authenticationapp.controller;

import com.mitre.authenticationapp.model.User;
import com.mitre.authenticationapp.service.MyAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class MyAdminController {

    private Logger log = LoggerFactory.getLogger(MyAdminController.class);

    @Autowired
    private MyAdminService myAdminService;

    @GetMapping()
    public ResponseEntity<String> admin(Authentication authentication) {
        log.info("hitting /admin route");

        return ResponseEntity.ok("Welcome " + authentication.getName());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User newUser) {
        log.info("hitting /admin/create route");

        myAdminService.createUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }
}
