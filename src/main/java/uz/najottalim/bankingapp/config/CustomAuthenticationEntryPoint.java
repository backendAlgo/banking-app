package uz.najottalim.bankingapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import uz.najottalim.bankingapp.dto.errorDto.ErrorDTO;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        PrintWriter stream = response.getWriter();
//        ErrorDTO errorDTO = ErrorDTO.builder()
//                .errors(authException.getMessage()).build();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(stream, errorDTO);
//        stream.flush();
//        response.setStatus(500);
        resolver.resolveException(request, response, null, authException);
    }
}
