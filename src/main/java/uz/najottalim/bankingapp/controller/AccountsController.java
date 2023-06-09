package uz.najottalim.bankingapp.controller;

import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.handler.DefaultWebFilterChain;
import uz.najottalim.bankingapp.dto.AccountsDTO;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {
    private AccountService accountService;

    @GetMapping
    public String accountsController() {
        return "accounts";
    }

    @GetMapping("/{id}")
    public Integer getBalance(@PathVariable Long id) {
        return 100;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("path: {}", request.getPathInfo());
        log.info("request: {}", request.getRequestURI());
        log.info("cookie: {}", Arrays.stream(request.getCookies())
                .map(cookie -> cookie.getValue())
                .collect(Collectors.toList()));
        return "Hello, Spring Security";
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountsDTO> getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping
    public ResponseEntity<List<AccountsDTO>> getAllAccount(){
        return accountService.getAllAccount();
    }

    @PostMapping
    public ResponseEntity<AccountsDTO> addAccount(@RequestBody AccountsDTO accountsDTO){
        return accountService.addAccount(accountsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountsDTO> updateAccount(@RequestBody AccountsDTO accountsDTO, @PathVariable Long id){
        return accountService.updateAccount(accountsDTO,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountsDTO> deleteAccount(@PathVariable Long id){
        return accountService.deleteAccount(id);
    }
}
