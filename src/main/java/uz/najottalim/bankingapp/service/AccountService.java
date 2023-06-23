package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import uz.najottalim.bankingapp.dto.AccountDto;

import java.util.List;
import java.util.Optional;

public interface  AccountService {
    ResponseEntity<AccountDto> getAccountById(Long id);

    ResponseEntity<List<AccountDto>> getAllAccounts(Optional<String> sortBy, Optional<Integer> size, Optional<Integer> pageNum);
}
