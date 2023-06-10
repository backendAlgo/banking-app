package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDTO;

import java.util.List;
import java.util.Optional;

public interface  AccountService {
    ResponseEntity<AccountDTO> getAccountById(Long id);

    ResponseEntity<List<AccountDTO>> getAllAccount(Optional<String> columnName, Optional<Integer> page, Optional<Integer> size);

    ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO);

    ResponseEntity<AccountDTO> updateAccount(AccountDTO accountDTO, Long id);

    ResponseEntity<AccountDTO> deleteAccount(Long id);

}
