package uz.najottalim.bankingapp.config;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;

public class RequestTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, @NotNull FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        long workTime = endTime - startTime;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println("Request to" + requestURI + " took "+ workTime+" ms ");
    }
}
