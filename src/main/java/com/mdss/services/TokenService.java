package com.mdss.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.mdss.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	
	private long expirationTime = (24 * 60 * 60 * 1000);
	
	private String key = "marcelo";
	
	public String generateToken(User user) {		
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(user.getName())
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime ))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}
}
