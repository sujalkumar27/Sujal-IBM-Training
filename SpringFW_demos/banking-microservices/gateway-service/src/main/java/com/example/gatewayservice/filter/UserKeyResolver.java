package com.example.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component("userKeyResolver")
public class UserKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        // Use JWT/token as the client key
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return Mono.just(authHeader);
        }

        // Otherwise use IP address
        if (exchange.getRequest().getRemoteAddress() != null) {
            return Mono.just(
                    exchange.getRequest()
                            .getRemoteAddress()
                            .getAddress()
                            .getHostAddress()
            );
        }

        return Mono.just("unknown-client");
    }
}