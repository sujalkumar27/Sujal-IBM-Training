package com.example.accountservice.consumer;

import com.example.accountservice.model.Transaction;
import com.example.accountservice.service.AccountTransactionService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTransactionConsumer {

    private final AccountTransactionService
            accountTransactionService;

    public KafkaTransactionConsumer(
            AccountTransactionService
                    accountTransactionService) {

        this.accountTransactionService =
                accountTransactionService;
    }

    @KafkaListener(
            topics = "transactions",
            groupId = "account-service"
    )
    public void consume(Transaction transaction) {

        System.out.println(
                "Received Kafka event: "
                        + transaction
        );

        accountTransactionService
                .processTransaction(transaction);
    }
}