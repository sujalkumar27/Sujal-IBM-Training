package com.example.payment;

import java.math.BigDecimal;
import java.util.UUID;

public class LegacyPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentResult pay(String customerId, BigDecimal amount) {
        System.out.println("[LEGACY] charging " + amount + " to " + customerId);
        return new PaymentResult(true, "LEG-" + UUID.randomUUID(), "legacy-bank");
    }
}
