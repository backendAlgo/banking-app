package uz.najottalim.bankingapp.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.security.Keys;
@Component
public class JsonUtility {
    private static  final int expireInMs=60*1000;
    private static  final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
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
        if (getUsername(token)!=null &&  isExpired(token)){
            return true;
        }
        return false;

    }

    public String  getUsername(String token){
        Claims claims= getClaims(token);
        return claims.getSubject();
    }
    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
