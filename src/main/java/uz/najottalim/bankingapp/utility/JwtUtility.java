package uz.najottalim.bankingapp.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtility {
    private static final int expireInMs = 120*1000;

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

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
}
