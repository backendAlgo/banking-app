package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;

import java.util.List;

public interface AccountService {
    ResponseEntity<List<AccountDto>> getAllAccounts();

    ResponseEntity<AccountDto> getById(Long id);

    ResponseEntity<AccountDto> addAccount(AccountDto accountDto);

    ResponseEntity<AccountDto> updateAccount(Long id,AccountDto accountDto);
}
