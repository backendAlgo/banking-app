package uz.najottalim.bankingapp.config;

import io.jsonwebtoken.Header;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class WordSplitterFilter  {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String[] words = request.getHeader("Words").split(",");
//        List<String> words1 = List.of(words);
//        log.info("words from header: {}",words1);
//        filterChain.doFilter(request,response);
//    }
}
