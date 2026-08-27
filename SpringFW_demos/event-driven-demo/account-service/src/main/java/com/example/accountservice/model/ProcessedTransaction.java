package com.example.accountservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "processed_transactions",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "transactionId"
                )
        }
)
public class ProcessedTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionId;

    @Column(nullable = false)
    private LocalDateTime processedAt;

    public ProcessedTransaction() {
    }

    public ProcessedTransaction(String transactionId) {
        this.transactionId = transactionId;
        this.processedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }
}