package com.example.minibankingspringboot.service;

import com.example.minibankingspringboot.entity.Account;
import com.example.minibankingspringboot.repository.AccountRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Cache-Aside
    // First request → Database
    // Next request → Redis
    @Cacheable(value = "accounts", key = "#accountId")
    public Account getAccountDetails(Long accountId) {

        System.out.println("Fetching from DB...");

        return accountRepository.findById(accountId)
                .orElseThrow();
    }


    // Write-Through
    // Updates Database and Redis
    @CachePut(value = "accounts", key = "#account.id")
    public Account updateAccount(Account account) {

        System.out.println("Updating DB...");

        return accountRepository.save(account);
    }


    // Cache Eviction
    // Deletes from Database and removes from Redis
    @CacheEvict(value = "accounts", key = "#accountId")
    public void deleteAccount(Long accountId) {

        System.out.println("Deleting from DB...");

        accountRepository.deleteById(accountId);
    }
}
