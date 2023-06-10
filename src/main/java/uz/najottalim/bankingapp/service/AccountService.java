package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;

import java.util.List;

public interface AccountService {
    ResponseEntity<AccountDto> findById(Long id);

    ResponseEntity<List<AccountDto>> findAll();

    ResponseEntity<AccountDto> save(AccountDto accountDto);

    void delete(Long id);

    ResponseEntity<AccountDto> update(AccountDto accountDto);
}
