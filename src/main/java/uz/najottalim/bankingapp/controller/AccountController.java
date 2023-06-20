package uz.najottalim.bankingapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping()
    public ResponseEntity<AccountDto> addAccount (@RequestBody AccountDto accountDto){
        return accountService.addAccount(accountDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount (@PathVariable Long id,@RequestBody AccountDto accountDto){
        return accountService.updateAccount(id,accountDto);
    }
}
