package uz.najottalim.bankingapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("path: {}", request.getPathInfo());
        log.info("request: {}", request.getRequestURI());
//        AuthorizationFilter
        log.info("cookie: {}", Arrays.stream(request.getCookies())
                .map(cookie -> cookie.getValue())
                .collect(Collectors.toList()));
        return "Hello, Spring Security";
    }

}
