package com.example.gatewayservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private final String SECRET =
            "mySecretKey123456789012345678901234567890";

    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token) {

        try {
            Claims claims = getClaims(token);

            return !claims.getExpiration()
                    .before(new java.util.Date());

        } catch (Exception e) {
            return false;
        }
    }
}