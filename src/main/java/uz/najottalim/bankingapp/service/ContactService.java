package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.messageDTO.ContactDto;

public interface ContactService {
        ResponseEntity<ContactDto> saveMassage(ContactDto contactDto);
}
