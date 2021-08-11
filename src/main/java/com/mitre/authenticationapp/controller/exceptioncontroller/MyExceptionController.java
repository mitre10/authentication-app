package com.mitre.authenticationapp.controller.exceptioncontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MyExceptionController implements ErrorController {

    Logger log = LoggerFactory.getLogger(MyExceptionController.class);

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        log.info("hitting /error route");

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("401 Unauthorized");
            }

            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("403 Forbidden");
            }

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Not Found");
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went bad");
    }
}
