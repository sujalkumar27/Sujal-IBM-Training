package com.example.gatewayservice.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String SECRET =
            "mySecretKey123456789012345678901234567890";

    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody Map<String, String> user) {

        String username = user.get("username");

        String token = Jwts.builder()
                .subject(username)
                .claim("role", "USER")
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + 3)
                )
                .signWith(secretKey)
                .compact();

        return Map.of("token", token);
    }
}
