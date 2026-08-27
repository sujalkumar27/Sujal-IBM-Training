package com.example.transactionservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic transactionTopic() {

        return new NewTopic(
                "transactions",
                3,
                (short) 1
        );
    }
}