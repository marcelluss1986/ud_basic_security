package com.mdss.services;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.mdss.entities.UserClient;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private static long expirationTime = (24 * 60 * 60 * 1000);

	private String key = "b3Mgb2xob3Mgc8OjbyB2ZXJkZXM=";

	public String generateToken(UserClient user) {
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis())).setSubject(user.getLogin())
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS512, key).compact();
	}

	private Claims getClaims(String token)throws ExpiredJwtException {
		return Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public Boolean validToken(String token) {
		try {
			Claims claims = getClaims(token);
			Date expiration = claims.getExpiration();
			java.time.LocalDateTime localDateTime = expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !java.time.LocalDateTime.now().isAfter(localDateTime);
		}catch(Exception e) {
			return null;
		}
	}
	
}
