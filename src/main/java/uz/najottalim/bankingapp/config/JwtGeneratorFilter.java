package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JsonUtility;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class JwtGeneratorFilter extends OncePerRequestFilter {
    private final JsonUtility jsonUtility;

    public JwtGeneratorFilter(JsonUtility jsonUtility) {
        this.jsonUtility = jsonUtility;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            String jwtToken = jsonUtility.generate(authentication.getName(),
                    authentication.getAuthorities()
                            .stream()
                            .map(grantedAuthority -> grantedAuthority.getAuthority())
                            .collect(Collectors.joining(",")));
            response.setHeader("Authorization",jwtToken);
        }
        filterChain.doFilter(request,response);
    }
}
