package com.example.orders;

public record OrderCreatedEvent(String orderId, String sku, int qty) {}
