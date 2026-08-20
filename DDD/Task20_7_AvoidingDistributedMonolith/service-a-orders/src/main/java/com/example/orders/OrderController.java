package com.example.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final String TOPIC = "order.created";

    private final KafkaTemplate<String, OrderCreatedEvent> kafka;

    public OrderController(KafkaTemplate<String, OrderCreatedEvent> kafka) {
        this.kafka = kafka;
    }

    public record OrderRequest(String sku, int qty) {}

    /*
     * BEFORE (distributed monolith):
     *
     *   inventoryClient.reserve(req.sku(), req.qty());   // blocking REST call
     *   return ResponseEntity.ok(...);
     *
     * AFTER: publish an event, return immediately. Service B reacts on its own.
     */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderRequest req) {
        String orderId = UUID.randomUUID().toString();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, req.sku(), req.qty());
        kafka.send(TOPIC, orderId, event);
        return ResponseEntity.accepted().body(orderId);
    }
}
