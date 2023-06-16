package uz.najottalim.bankingapp.config;

import java.io.IOException;
import java.util.Arrays;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class WordSplitterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String customHeader = httpServletRequest.getHeader("words");

        if (customHeader != null){
            String [] words = customHeader.split(",");
            System.out.println(Arrays.toString(words));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
