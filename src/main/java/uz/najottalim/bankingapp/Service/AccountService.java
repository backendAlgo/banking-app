package uz.najottalim.bankingapp.Service;


import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;

import java.util.List;

public interface AccountService{


    ResponseEntity<List<AccountDto>> getAll();

}
