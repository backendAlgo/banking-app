package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import uz.najottalim.bankingapp.dto.AccountDTO;

import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {
    ResponseEntity<List<AccountDTO>> getAllAccounts();


    ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO);

    ResponseEntity<AccountDTO> getById(Long id);
}
