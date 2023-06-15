package uz.najottalim.bankingapp.config;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CustomLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("request: {}", Arrays.stream(((HttpServletRequest) request).getCookies()).map(c -> c.getValue()).toList());
//        log.info("response: {}", response.getBufferSize());
        chain.doFilter(request, response);
    }
}