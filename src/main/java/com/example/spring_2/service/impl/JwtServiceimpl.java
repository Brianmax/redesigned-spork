package com.example.spring_2.service.impl;

import com.example.spring_2.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hibernate.sql.ast.tree.from.StandardTableGroup;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtServiceimpl implements JwtService {
    @Override
    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("prueba", "Esta es una prueba de agregar un claim");
        claims.put("prueba2", 8989);
        return Jwts.builder()
                .setClaims(claims)
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
        Claims claims = extractClaims(token);
        String username = claims.getSubject();
        return username;
    }

    private Key getSignKey() {
        byte[] key = Decoders.BASE64.decode("85732b878c0f544da4a863804775ef3914e8ccb82b08820a278302c5b826e291");
        return Keys.hmacShaKeyFor(key);
    }

    private boolean isTokenExpired(String token) {
        Claims claims = extractClaims(token);
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date(System.currentTimeMillis()))) {
            return true;
        }
        return false;
    }

    private Claims extractClaims(String token) {
        return Jwts.
                parserBuilder().
                setSigningKey(getSignKey()).build().parseClaimsJws(token).
                getBody();
    }
}
