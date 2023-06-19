package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;

import java.util.List;
import java.util.Optional;

public interface  AccountsService {
    ResponseEntity<AccountDto> getAccountById(Long id);

    ResponseEntity<AccountDto> addAccount(AccountDto accountDTO);

    ResponseEntity<AccountDto> updateAccount(AccountDto accountDTO, Long id);

    ResponseEntity<AccountDto> deleteAccount(Long id);

}