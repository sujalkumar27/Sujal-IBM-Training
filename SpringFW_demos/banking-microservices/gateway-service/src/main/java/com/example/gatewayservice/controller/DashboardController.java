package com.example.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public Map<String, Object> getDashboard(@PathVariable Long id) {

        // Call Account Service
        Double balance = restTemplate.getForObject(
                "http://localhost:8082/" + id + "/balance",
                Double.class
        );

        // Call Transaction Service
        List<String> transactions = restTemplate.getForObject(
                "http://localhost:8083/" + id,
                List.class
        );

        // Aggregate responses
        return Map.of(
                "accountId", id,
                "balance", balance,
                "transactions", transactions
        );
    }
}