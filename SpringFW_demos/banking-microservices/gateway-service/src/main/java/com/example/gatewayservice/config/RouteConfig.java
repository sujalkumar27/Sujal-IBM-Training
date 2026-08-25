package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, KeyResolver userKeyResolver) {

        // Account: 5 requests/sec, burst 10
        RedisRateLimiter accountRateLimiter =
                new RedisRateLimiter(5, 10);

        // Transaction: 3 requests/sec, burst 6
        RedisRateLimiter transactionRateLimiter =
                new RedisRateLimiter(3, 6);

        return builder.routes()

                // Account Service
                .route("account_route", r -> r
                        .path("/account/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8082"))

                // Transaction Service
                .route("transaction_route", r -> r
                        .path("/transaction/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8083"))

                .build();
    }

//    @Bean
//    public RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(5, 10);
//    }
}