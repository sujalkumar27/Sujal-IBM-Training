package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.ProcessedTransaction;
import com.example.accountservice.model.Transaction;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.repository.ProcessedTransactionRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountTransactionService {

    private final AccountRepository accountRepository;

    private final ProcessedTransactionRepository
            processedTransactionRepository;

    public AccountTransactionService(
            AccountRepository accountRepository,
            ProcessedTransactionRepository
                    processedTransactionRepository) {

        this.accountRepository = accountRepository;
        this.processedTransactionRepository =
                processedTransactionRepository;
    }

    @Transactional
    public void processTransaction(
            Transaction transaction) {

        System.out.println(
                "Processing transaction: "
                        + transaction
        );

        // ---------------------------------------
        // 1. Idempotency check
        // ---------------------------------------

        if (processedTransactionRepository
                .existsByTransactionId(transaction.getId())) {

            System.out.println(
                    "Transaction already processed: "
                            + transaction.getId()
            );

            return;
        }

        // ---------------------------------------
        // 2. Find account
        // ---------------------------------------

        Account account =
                accountRepository
                        .findByUserId(transaction.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Account not found for user: "
                                                + transaction.getUserId()
                                )
                        );

        // ---------------------------------------
        // 3. Update balance
        // ---------------------------------------

        account.setBalance(
                account.getBalance()
                        .subtract(transaction.getAmount())
        );

        accountRepository.save(account);

        // ---------------------------------------
        // 4. Record transaction
        // ---------------------------------------

        try {

            processedTransactionRepository.save(
                    new ProcessedTransaction(
                            transaction.getId()
                    )
            );

        } catch (DataIntegrityViolationException ex) {

            /*
             * Another consumer may have processed
             * the same transaction concurrently.
             */
            System.out.println(
                    "Duplicate transaction detected: "
                            + transaction.getId()
            );
        }

        System.out.println(
                "Balance updated successfully."
        );
    }
}