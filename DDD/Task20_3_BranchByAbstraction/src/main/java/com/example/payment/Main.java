package com.example.payment;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = PaymentProcessorFactory.create();
        PaymentResult result = processor.pay("cust-42", new BigDecimal("199.99"));
        System.out.println(result);
    }
}
