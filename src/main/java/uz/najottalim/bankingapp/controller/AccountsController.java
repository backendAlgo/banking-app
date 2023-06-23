package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.TransactionDto;
import uz.najottalim.bankingapp.models.Transaction;
import uz.najottalim.bankingapp.service.AccountService;
import uz.najottalim.bankingapp.service.TransactionService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
@EnableMethodSecurity
public class AccountsController {
    private final AccountService accountService;
    private final TransactionService transactionService;


    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(@RequestParam Optional<String> sortBy,
                                                           @RequestParam Optional<Integer> size,
                                                           @RequestParam Optional<Integer> pageNum) {
        return accountService.getAllAccounts(sortBy,size,pageNum);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/{id}/balances")
    @PostAuthorize("returnObject.body.get(0).accountNumber == #id")
    public ResponseEntity<List<TransactionDto>> getTransactionByAccountId(@PathVariable Long id, Principal principal){
        return transactionService.findByAccountId(id);
    }


}
