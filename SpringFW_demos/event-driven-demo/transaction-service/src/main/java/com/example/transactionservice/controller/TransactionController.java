package com.example.transactionservice.controller;

import com.example.transactionservice.model.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static final String KAFKA_TOPIC =
            "transactions";

    private static final String RABBIT_EXCHANGE =
            "transaction-exchange";

    private static final String RABBIT_ROUTING_KEY =
            "transaction.key";

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    private final AmqpTemplate amqpTemplate;

    public TransactionController(
            KafkaTemplate<String, Transaction> kafkaTemplate,
            AmqpTemplate amqpTemplate) {

        this.kafkaTemplate = kafkaTemplate;
        this.amqpTemplate = amqpTemplate;
    }

    // ------------------------------------------
    // Kafka Producer
    // ------------------------------------------

    @PostMapping("/kafka")
    public ResponseEntity<String> createKafkaTransaction(
            @RequestBody Transaction transaction) {

        generateTransactionId(transaction);

        kafkaTemplate.send(
                KAFKA_TOPIC,
                transaction.getUserId().toString(),
                transaction
        );

        System.out.println(
                "Published transaction to Kafka: "
                        + transaction
        );

        return ResponseEntity.ok(
                "Transaction submitted to Kafka: "
                        + transaction.getId()
        );
    }

    // ------------------------------------------
    // RabbitMQ Producer
    // ------------------------------------------

    @PostMapping("/rabbit")
    public ResponseEntity<String> createRabbitTransaction(
            @RequestBody Transaction transaction) {

        generateTransactionId(transaction);

        amqpTemplate.convertAndSend(
                RABBIT_EXCHANGE,
                RABBIT_ROUTING_KEY,
                transaction
        );

        System.out.println(
                "Published transaction to RabbitMQ: "
                        + transaction
        );

        return ResponseEntity.ok(
                "Transaction submitted to RabbitMQ: "
                        + transaction.getId()
        );
    }

    // ------------------------------------------
    // Generate ID if not provided
    // ------------------------------------------

    private void generateTransactionId(
            Transaction transaction) {

        if (transaction.getId() == null ||
                transaction.getId().isBlank()) {

            transaction.setId(
                    UUID.randomUUID().toString()
            );
        }
    }
}