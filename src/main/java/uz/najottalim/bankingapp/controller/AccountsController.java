package uz.najottalim.bankingapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.handler.DefaultWebFilterChain;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountsController {
    private final AccountService accountService;
    @GetMapping
    public String accountsController() {
        return "accounts";
    }
    @GetMapping
    public ResponseEntity<List<AccountsDto>> getAllAccounts(){
        return accountService.getAllAccounts();
    }
//    @GetMapping("/hello")
//    public String hello(HttpServletRequest request) {
//        log.info("path: {}", request.getPathInfo());
//        log.info("request: {}", request.getRequestURI());
//        log.info("cookie: {}", Arrays.stream(request.getCookies())
//                .map(cookie -> cookie.getValue())
//                .collect(Collectors.toList()));
//        return "Hello, Spring Security";
//    }
}
