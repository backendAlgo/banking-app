package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.Repository.AccountRepository;
import uz.najottalim.bankingapp.mapper.AccountMapper;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private  final AccountRepository accountRepository;

    @GetMapping("/user")
    public AccountsDto loginUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return AccountMapper.toDto(accountRepository.findByEmail(auth.getName()).orElseThrow(() -> new IllegalArgumentException("cannot be here")));
    }
}
