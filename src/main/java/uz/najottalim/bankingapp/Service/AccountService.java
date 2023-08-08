package uz.najottalim.bankingapp.Service;


import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.TransactionDto;

import java.util.List;

public interface AccountService{

    ResponseEntity<AccountDto> getById(Long id);

    ResponseEntity<List<TransactionDto>> getBalanceById(Long id);

}
