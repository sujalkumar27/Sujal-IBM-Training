package com.example.transactionservice.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE =
            "transaction-exchange";

    public static final String QUEUE =
            "transaction-queue";

    public static final String ROUTING_KEY =
            "transaction.key";

    @Bean
    public DirectExchange transactionExchange() {

        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue transactionQueue() {

        return new Queue(
                QUEUE,
                true
        );
    }

    @Bean
    public Binding transactionBinding(
            Queue transactionQueue,
            DirectExchange transactionExchange) {

        return BindingBuilder
                .bind(transactionQueue)
                .to(transactionExchange)
                .with(ROUTING_KEY);
    }
}
