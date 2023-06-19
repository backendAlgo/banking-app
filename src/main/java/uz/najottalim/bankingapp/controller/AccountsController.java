package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.service.AccountsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDTO){
        return accountService.addAccount(accountDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDTO, @PathVariable Long id){
        return accountService.updateAccount(accountDTO,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id){
        return accountService.deleteAccount(id);
    }
}
