package uz.najottalim.bankingapp.config;

import jakarta.servlet.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class CustomLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
