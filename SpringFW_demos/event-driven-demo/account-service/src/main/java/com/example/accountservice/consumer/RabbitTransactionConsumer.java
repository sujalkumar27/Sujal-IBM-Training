package com.example.accountservice.consumer;

import com.example.accountservice.model.Transaction;
import com.example.accountservice.service.AccountTransactionService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitTransactionConsumer {

    private final AccountTransactionService
            accountTransactionService;

    public RabbitTransactionConsumer(
            AccountTransactionService
                    accountTransactionService) {

        this.accountTransactionService =
                accountTransactionService;
    }

    @RabbitListener(queues = "transaction-queue")
    public void receive(Transaction transaction) {

        System.out.println(
                "Received RabbitMQ event: "
                        + transaction
        );

        accountTransactionService
                .processTransaction(transaction);
    }
}