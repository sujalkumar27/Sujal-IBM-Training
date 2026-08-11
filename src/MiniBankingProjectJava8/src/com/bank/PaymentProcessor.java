package com.bank;

@FunctionalInterface
public interface PaymentProcessor {

    void process(int amount);
}