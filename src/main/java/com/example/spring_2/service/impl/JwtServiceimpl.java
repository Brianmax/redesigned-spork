package com.example.spring_2.service.impl;

import com.example.spring_2.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtServiceimpl implements JwtService {
    @Override
    public String generateToken(UserDetails userDetails) {
        Claims
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        String usernameDetails = userDetails.getUsername();

        if (username.equals(usernameDetails) && isTokenExpired(token)) {
            return false;
        }
        return true;
    }

    @Override
    public String extractUsername(String token) {
        return "";
    }

    private Key getSignKey() {
        byte[] key = Decoders.BASE64.decode("");
        return Keys.hmacShaKeyFor(key);
    }

    private boolean isTokenExpired(String token) {
        // todo: extraer la fecha de expiracion del token
        // todo: comparar la fecha actual con la fecha de expiracion
        return false;
    }
}
