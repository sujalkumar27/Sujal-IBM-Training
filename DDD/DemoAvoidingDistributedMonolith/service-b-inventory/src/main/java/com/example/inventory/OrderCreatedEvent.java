package com.example.inventory;

public record OrderCreatedEvent(String orderId, String sku, int qty) {}
