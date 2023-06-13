package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDTO;

import java.util.List;

public interface  AccountService {
    ResponseEntity<List<AccountDTO>> getAllAccounts();


    ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO);
<<<<<<< HEAD
}
=======
}
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
