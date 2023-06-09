package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountsDTO;

import java.util.List;

public interface  AccountService {
    ResponseEntity<AccountsDTO> getAccountById(Long id);

    ResponseEntity<List<AccountsDTO>> getAllAccount();

    ResponseEntity<AccountsDTO> addAccount(AccountsDTO accountsDTO);

    ResponseEntity<AccountsDTO> updateAccount(AccountsDTO accountsDTO, Long id);

    ResponseEntity<AccountsDTO> deleteAccount(Long id);

}
