package com.ptit.newspaper.config.jwt;

import com.ptit.newspaper.config.security.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtUtils {

    private final static org.slf4j.Logger Logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.jwtSecret}")
    private  String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            Logger.error("Invalid JWT Token: {}", e.getMessage());
        } catch (ExpiredJwtException e){
            Logger.error("Invalid JWT expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e){
            Logger.error("Invalid JWT unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e){
            Logger.error("JWT claims string empty : {}", e.getMessage());
        }
        return false;
    }

}