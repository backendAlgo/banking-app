package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getName();
        return accountService.getAccountById(id);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccount(@RequestParam Optional<Integer> page,
                                                          @RequestParam Optional<Integer> size,
                                                          @RequestParam Optional<String> columnName){
        return accountService.getAllAccount(columnName,page, size);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return accountService.addAccount(accountDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable Long id){
        return accountService.updateAccount(accountDTO,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id){
        return accountService.deleteAccount(id);
    }
}
