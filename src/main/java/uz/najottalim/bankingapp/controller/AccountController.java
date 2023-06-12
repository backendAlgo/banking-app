package uz.najottalim.bankingapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.servise.AccountService;

import java.util.*;


@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id){
        return accountService.getById(id);
    }
}
