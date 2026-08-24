package com.example.transaction.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/transaction")
public class TransactionController {

    @GetMapping("/{id}")
    public List<String> getTransactions(@PathVariable Long id) {

        return List.of(
                "TXN1001 - Debit 500",
                "TXN1002 - Credit 2000"
        );
    }
}