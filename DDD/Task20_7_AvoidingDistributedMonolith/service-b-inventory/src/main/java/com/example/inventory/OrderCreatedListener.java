package com.example.inventory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @KafkaListener(topics = "order.created", groupId = "inventory-service")
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.printf(
                "[inventory] reserving qty=%d of sku=%s for order=%s%n",
                event.qty(), event.sku(), event.orderId());
        // TODO: actually decrement stock in the DB
    }
}
