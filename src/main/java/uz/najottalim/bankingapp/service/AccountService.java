package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;

import java.util.List;

public interface AccountService {

    ResponseEntity<List<AccountDto>> getAllAccounts();

    ResponseEntity<AccountDto> getById(Long id);

    ResponseEntity<AccountDto> addAccount(AccountDto accountDto);
}
