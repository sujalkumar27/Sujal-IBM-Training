package com.example.transactionservice.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class Transaction {

    @NotNull
    private String id;

    @NotNull
    private Long userId;

    @NotNull
    @DecimalMin(value = "0.01")
    private Double amount;

    public Transaction() {
    }

    public Transaction(
            String id,
            Long userId,
            Double amount) {

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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