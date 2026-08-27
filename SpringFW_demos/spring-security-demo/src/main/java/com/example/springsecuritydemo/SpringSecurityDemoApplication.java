package com.example.springsecuritydemo;

import com.example.springsecuritydemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringSecurityDemoApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner initUsers(UserService userService) {

        return args -> {

            try {
                userService.registerUser(
                        "user",
                        "password",
                        "USER"
                );
            } catch (Exception ignored) {
            }

            try {
                userService.registerUser(
                        "admin",
                        "admin123",
                        "ADMIN"
                );
            } catch (Exception ignored) {
            }
        };
    }
}

