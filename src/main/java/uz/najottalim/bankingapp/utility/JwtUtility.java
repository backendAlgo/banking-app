package uz.najottalim.bankingapp.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Component
public class JwtUtility {
    private static final int expireInMs = 3600*1000;
    private static final String secretKey = "myBankingAppForSimpleBankServices";
    private static final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

//    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generate(String username ,String authorities){
        return Jwts.builder()
                .setSubject("FOR-LOGIN")
                .setIssuer("BANKING -APP")
                .claim("username",username)
                .claim("authorities",authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))
                .signWith(key)
                .compact();
    }
    public boolean validate(String token) {
        if (getUsername(token) != null && !isExpired(token) && getAuthorities(token).size() != 0) {
            return true;
        }
        return false;
    }
    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.get("username").toString();
    }
    public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        Claims claims = getClaims(token);
        return Arrays.stream(claims.get("authorities", String.class)
                        .split(", ")).
                map(SimpleGrantedAuthority::new)
                .toList();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
