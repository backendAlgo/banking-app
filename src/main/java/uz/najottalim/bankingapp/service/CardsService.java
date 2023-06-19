package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.AccountDto;

public interface CardsService {
    ResponseEntity<AccountDto> getCardById(Long id);

    ResponseEntity<AccountDto> addCard(AccountDto accountDTO);

    ResponseEntity<AccountDto> updateCard(AccountDto accountDTO, Long id);

    ResponseEntity<AccountDto> deleteCard(Long id);

}
