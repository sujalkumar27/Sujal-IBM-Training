package com.example.payment;

import java.math.BigDecimal;

public interface PaymentProcessor {
    PaymentResult pay(String customerId, BigDecimal amount);
}
