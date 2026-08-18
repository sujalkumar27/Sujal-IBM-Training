package com.example.minibankingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiniBankingSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(MiniBankingSpringBootApplication.class, args);

    }

}
