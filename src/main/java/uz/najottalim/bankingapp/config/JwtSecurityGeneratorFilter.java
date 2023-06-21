package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JWTUtility;

import java.io.IOException;
import java.util.stream.Collectors;

public class JwtSecurityGeneratorFilter extends OncePerRequestFilter {
    private final JWTUtility jsonUtility;

    public JwtSecurityGeneratorFilter(JWTUtility jsonUtility) {
        this.jsonUtility = jsonUtility;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String jwtToken = jsonUtility.generate(authentication.getName(),
                    authentication.getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.joining(", "))
            );
            response.setHeader("Custom-Authorization", jwtToken);
            /**
             * {
             *  "username" : authusername,
             *  "authorities": "ROLE_ADMIN, ROLE_USER, READ"
             * }
             *
             */
        }
        filterChain.doFilter(request, response);
    }
}