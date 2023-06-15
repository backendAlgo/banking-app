package uz.najottalim.bankingapp.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class RequestTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        log.info("Request received for URL: {}", httpRequest.getRequestURL());
        LocalDateTime now = LocalDateTime.now();
        log.info("Request received at: {}", now.format(DateTimeFormatter.ISO_DATE_TIME));
        chain.doFilter(request, response);

    }


}

