package uz.najottalim.bankingapp.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Enumeration;

@Service
@Slf4j
public class WordSplitterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                if (name.equals("words")){
                    String[] split = httpRequest.getHeader(name).split(",");
                    for (String s : split) {
                        log.info("words : {}", s);
                    }
                }
            }
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
        }


        chain.doFilter(request, response);


    }
}
