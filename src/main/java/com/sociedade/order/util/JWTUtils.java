package com.sociedade.order.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.function.Function;

@Component
public class JWTUtils implements Serializable {

    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token) {
        String claims = getClaimFromToken(token, Claims::getSubject);
        return claims.replaceFirst("-tenant:[a-zA-Z0-9\\s]*", "");
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
