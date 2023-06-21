package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JWTUtility;

import java.io.IOException;
import java.util.Collection;

@Slf4j
public class JwtSecurityCheckFilter extends OncePerRequestFilter {
    private final JWTUtility jsonUtility;

    public JwtSecurityCheckFilter(JWTUtility jsonUtility) {
        this.jsonUtility = jsonUtility;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Custom-Authorization");
        if (token != null) {
            try {
                if (jsonUtility.validate(token)) {
                    String username = jsonUtility.getUsername(token);
                    Collection<? extends GrantedAuthority> authorities = jsonUtility.getAuthorities(token);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            authorities
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    throw new IllegalArgumentException("token cannot be validated");
                }
            } catch (Exception ex) {
                log.info("Exception occurred: ", ex);
                throw new BadCredentialsException("not correct JWT token", ex);
            }
        }
        filterChain.doFilter(request, response);
    }
}