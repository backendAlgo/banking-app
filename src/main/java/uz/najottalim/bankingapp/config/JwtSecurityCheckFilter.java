package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JsonUtility;

import java.io.IOException;

public class JwtSecurityCheckFilter extends OncePerRequestFilter {
    private JsonUtility jsonUtility;

    public JwtSecurityCheckFilter(JsonUtility jsonUtility) {
        this.jsonUtility = jsonUtility;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
//        BasicAuthenticationFilter
        String username = jsonUtility.getUsername(token);
        var auth = jsonUtility.getAuthorities(token);
        if (token != null && jsonUtility.validate(token)) {

            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);









//            response.setHeader("sherzod", "sadasd");
        }
    }
}
