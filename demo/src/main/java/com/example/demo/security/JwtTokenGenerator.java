package com.example.demo.security;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {

    // Chave secreta para assinar o token
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token fixo para fins de exemplo
    private static final String FIXED_TOKEN = "@e2etreinamentos102030";

    // Método para gerar um token JWT com uma expiração específica
    public String generateToken(String username, long expirationMillis) {
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMillis);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    // Método para gerar um token JWT com uma expiração padrão (por exemplo, 1 hora)
    public String generateToken(String username) {
        // Expiração padrão de 1 hora
        long expirationMillis = 3600000;
        return generateToken(username, expirationMillis);
    }

    // Método para gerar o token fixo para fins de exemplo
    public String generateFixedToken() {
        return FIXED_TOKEN;
    }

    // Método para verificar se um token é válido
    public boolean isValidToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
