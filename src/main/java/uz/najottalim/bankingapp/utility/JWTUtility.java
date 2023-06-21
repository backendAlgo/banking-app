package uz.najottalim.bankingapp.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
public class JWTUtility {
    private static final Integer expireInMs = 600 * 1000;

    private static final String SECRET_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    private final static SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generate(String username, String authorities) {
        String jwtToken = Jwts.builder()
                .setSubject("FOR-LOGIN")
                .setIssuer("BANKING-APP")
                .claim("username", username)
                .claim("authorities", authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))
                .signWith(key)
                .compact();
        return jwtToken;
//        BasicAuthenticationFilter
    }

    public boolean validate(String token) {

        return getUsername(token) != null &&
                !isExpired(token)
                && getAuthorities(token).size() > 0;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.get("username", String.class);
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