package com.example.accountservice.repository;

import com.example.accountservice.model.ProcessedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedTransactionRepository
        extends JpaRepository<ProcessedTransaction, Long> {

    boolean existsByTransactionId(String transactionId);
}