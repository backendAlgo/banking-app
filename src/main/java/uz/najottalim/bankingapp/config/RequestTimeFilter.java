package uz.najottalim.bankingapp.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;

@Service
@Slf4j
public class RequestTimeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("request-Time: {}", LocalTime.now());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
