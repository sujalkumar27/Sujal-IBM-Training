package com.example.accountservice.model;

import java.math.BigDecimal;

public class Transaction {

    private String id;

    private Long userId;

    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(
            String id,
            Long userId,
            BigDecimal amount) {

        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}