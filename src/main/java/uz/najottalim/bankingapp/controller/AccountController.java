package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.Service.AccountService;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.TransactionDto;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @GetMapping("/{userId}/balances")
    public ResponseEntity<List<TransactionDto>> getBalanceByUserId(@PathVariable Long userId){
        return accountService.getBalanceById(userId);
    }
}
