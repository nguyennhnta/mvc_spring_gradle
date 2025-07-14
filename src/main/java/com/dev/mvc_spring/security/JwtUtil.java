package com.dev.mvc_spring.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Component
public class JwtUtil {
	
	 @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiration}")
	    private long expiration;

		//cân nhắc trước khi dùng key với tự dộng
//		private static final Key keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	    private SecretKey getSigningKey() {
	        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }

	    public String generateToken(String username) {
	        return Jwts.builder()
	            .setSubject(username)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + expiration))
	            .signWith(getSigningKey()) 
	            .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parser()
	            .setSigningKey(getSigningKey())  
	            .build()
	            .parseClaimsJws(token)
	            .getBody()
	            .getSubject();
	    }

	    public boolean validateToken(String token) {
	    	try {
	            Jwts.parser()
	                .setSigningKey(getSigningKey()) 
	                .build()
	                .parseClaimsJws(token);
	            return true;
	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }

}
