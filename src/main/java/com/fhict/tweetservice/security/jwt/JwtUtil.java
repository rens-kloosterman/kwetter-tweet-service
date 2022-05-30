package com.fhict.tweetservice.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

import static com.fhict.tweetservice.constants.Constants.SECRET_KEY;

@Service
public class JwtUtil {

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            System.out.println(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject());
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature.");
            System.out.println("Invalid JWT signature trace: " + e);
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token.");
            System.out.println("Invalid JWT token trace: " + e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token.");
            System.out.println("Expired JWT token trace: " + e);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token.");
            System.out.println("Unsupported JWT token trace: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("JWT token compact of handler are invalid.");
            System.out.println("JWT token compact of handler are invalid trace: " + e);
        }
        return false;
    }
}