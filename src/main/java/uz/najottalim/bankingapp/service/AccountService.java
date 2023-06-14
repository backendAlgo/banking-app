package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Dto.AccountsDto;

import java.util.List;


public interface AccountService {
    ResponseEntity<List<AccountsDto>> getAllAccounts();

    ResponseEntity<String> addAccount(AccountsDto accountsDto);
}
