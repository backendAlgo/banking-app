package uz.najottalim.bankingapp.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JsonUtility {
    private static  final int expireInMs=60*1000;
    private static final String SECRET_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    private static final SecretKey key =Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    public  String generate(String username,String authorities){
         String jwtToken= Jwts.builder()
                 .setSubject("For-Login")
                 .setIssuer("Banking-app")
                 .claim("username",username)
                 .claim("authorities",authorities)
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis()+expireInMs))
                 .signWith(key)
                 .compact();
         return jwtToken;
    }
    public boolean validate(String token){
        if (getUsername(token)!=null &&  isExpired(token) && getAuthority(token).size()>0){
            return true;
        }
        return false;

    }

    public Collection<? extends GrantedAuthority> getAuthority(String token){
        Claims claims= getClaims(token);
        return Arrays.stream(claims.get("authorities",String.class)
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
    public String  getUsername(String token){
        Claims claims= getClaims(token);
        return claims.get("username",String.class);
    }
    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
