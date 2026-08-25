package com.example.gatewayservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/rate-limit-error")
    public ResponseEntity<String> rateLimitError() {

        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .body("You have exceeded the allowed request limit. Please try again later.");
    }
}