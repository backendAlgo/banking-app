package uz.najottalim.bankingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto){
        return accountService.save(accountDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> read(@PathVariable Long id){
        return accountService.findById(id);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>> readAll(){
        return accountService.findAll();
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto accountDto) {
        return accountService.update(accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        accountService.delete(id);
    }


}
