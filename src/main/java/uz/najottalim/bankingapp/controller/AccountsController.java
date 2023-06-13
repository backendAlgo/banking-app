package uz.najottalim.bankingapp.controller;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
=======
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.service.AccountService;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88

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


<<<<<<< HEAD
}
=======
}
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
