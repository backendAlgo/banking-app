package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;

public interface AccountService {
    ResponseEntity<AccountDto> findById(Long id);
}
