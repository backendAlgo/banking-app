package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.dto.accountsdto.UserDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.servise.mapper.AccountMapper;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AccountRepository accountRepository;
    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserDetailsAfterLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountRepository
                .findByEmail(authentication.getName())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return ResponseEntity.ok(AccountMapper.toUserDto(account));
    }
}
