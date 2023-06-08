package uz.najottalim.bankingapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.handler.DefaultWebFilterChain;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("path: {}", request.getPathInfo());
        log.info("request: {}", request.getRequestURI());
        log.info("cookie: {}", Arrays.stream(request.getCookies())
                .map(cookie -> cookie.getValue())
                .collect(Collectors.toList()));
        return "Hello, Spring Security";
    }
}
