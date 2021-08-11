package com.mitre.authenticationapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleController {

    private Logger log = LoggerFactory.getLogger(MySimpleController.class);

    @GetMapping("/")
    public ResponseEntity home() {
        log.info("hitting / route");

        return ResponseEntity.ok("Welcome");
    }
}
