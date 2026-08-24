package com.example.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/account")
public class AccountController {

    @GetMapping("/{id}/balance")
    public Double getBalance(@PathVariable Long id) {
        return 50000.50;
    }
}