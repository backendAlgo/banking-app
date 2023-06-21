package uz.najottalim.bankingapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.addAccount(accountDTO);
    }

    @PutMapping
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAllAccounts().getBody().get(0));
    }


    @GetMapping("/{userId}/balances")
    public ResponseEntity<List<TransactionDTO>> getTransactionByUserId(@PathVariable Long userId) {
        return accountService.getBalanceByUserId(userId);
    }


}
