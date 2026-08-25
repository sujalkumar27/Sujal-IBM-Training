package com.example.gatewayservice.filter;

import com.example.gatewayservice.utils.JwtUtil;
import io.jsonwebtoken.Claims;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements GlobalFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String path = exchange.getRequest()
                .getURI()
                .getPath();

        // Login should be accessible without JWT
        if (path.equals("/auth/login")) {
            return chain.filter(exchange);
        }

        // Get Authorization header
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        // JWT missing
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // Extract token
        String token = authHeader.substring(7);

        // Empty token
        if (token.isBlank()) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // Validate JWT
        if (!jwtUtil.validateToken(token)) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // Get JWT claims
        Claims claims = jwtUtil.getClaims(token);

        String userId = claims.getSubject();
        String role = claims.get("role", String.class);

        // Add user information to request
        ServerHttpRequest modifiedRequest =
                exchange.getRequest()
                        .mutate()
                        .header("X-User-Id", userId)
                        .header("X-User-Role", role)
                        .build();

        // Create modified exchange
        ServerWebExchange modifiedExchange =
                exchange.mutate()
                        .request(modifiedRequest)
                        .build();

        // Continue request
        return chain.filter(modifiedExchange);
    }
}