package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JwtUtility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class RequestTimeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Request arrive at :{}" , localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        filterChain.doFilter(request,response);
    }
}
