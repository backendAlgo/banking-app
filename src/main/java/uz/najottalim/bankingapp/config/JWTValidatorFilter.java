package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.exception.TokenValidationException;
import uz.najottalim.bankingapp.utility.JwtUtility;

import java.io.IOException;
import java.util.Collection;
@Service
@RequiredArgsConstructor
@Slf4j
public class JWTValidatorFilter extends OncePerRequestFilter {
    private final JwtUtility jwtUtility;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String value = request.getHeader("authorization");
        if(value != null){
            try {
                if (jwtUtility.validate(value)) {
                    String username = jwtUtility.getUsername(value);
                    Collection<? extends GrantedAuthority> authorities = jwtUtility.getAuthorities(value);
                    Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authorities);

                    SecurityContextHolder.getContext().setAuthentication(auth);

                }else {
                    throw new TokenValidationException("Token not valid");
                }
            }catch(Exception ex){
                log.info("Token validation exception {}",ex.getMessage());
            }finally {
                filterChain.doFilter(request,response);
            }
        }
        else{
            filterChain.doFilter(request, response);
        }
    }
}
