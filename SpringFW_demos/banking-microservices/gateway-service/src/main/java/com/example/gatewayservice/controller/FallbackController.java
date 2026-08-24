package com.example.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/transaction")
    public String transactionFallback() {
        return "Transaction service is currently unavailable. Please try later.";
    }
}