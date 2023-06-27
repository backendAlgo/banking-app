package uz.najottalim.bankingapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.dto.errors.ErrorDTO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@Slf4j
public class CustomLoggingFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        log.info("request: {}", Arrays.stream(((HttpServletRequest) request).getCookies()).map(c -> c.getValue()).toList());
//        log.info("response: {}", response.getBufferSize());
        try {
            log.info("CustomLogicFilter called");
            chain.doFilter(request, response);
        } catch (Throwable throwable) {
//            log.info("inside CustomLogicFilter called");
            PrintWriter stream = response.getWriter();
//            stream.write("some");
//            stream.flush();
            ErrorDTO errorDTO = ErrorDTO.builder()
                    .errors(throwable.getMessage()).build();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(stream, errorDTO);
            stream.flush();
            response.setStatus(500);
        }
    }
}
