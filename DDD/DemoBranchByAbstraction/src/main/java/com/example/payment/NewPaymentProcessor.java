package com.example.payment;

import java.math.BigDecimal;
import java.util.UUID;

public class NewPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentResult pay(String customerId, BigDecimal amount) {
        System.out.println("[NEW] Stripe charge " + amount + " to " + customerId);
        return new PaymentResult(true, "STR-" + UUID.randomUUID(), "stripe");
    }
}
