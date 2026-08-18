package com.example.minibankingspringboot.controller;

import com.example.minibankingspringboot.entity.Account;
import com.example.minibankingspringboot.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    // Get account
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {

        return accountService.getAccountDetails(id);
    }


    // Create / Update account
    @PostMapping("/update")
    public Account updateAccount(@RequestBody Account account) {

        return accountService.updateAccount(account);
    }


    // Delete account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {

        accountService.deleteAccount(id);

        return "Account deleted successfully";
    }
}
