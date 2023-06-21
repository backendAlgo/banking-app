package uz.najottalim.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.repository.AccountRepository;

@RestController
public class LoginController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/user")
    public ResponseEntity<AccountDTO> loginUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(
                AccountMapper.toDto(accountRepository
                        .findByEmail(auth.getName())
                        .orElseThrow(() -> new IllegalArgumentException("cannot be here"))));
    }
}