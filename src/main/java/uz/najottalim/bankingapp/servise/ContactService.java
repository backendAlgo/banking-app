package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.messagedto.ContactDto;

public interface ContactService {
    ResponseEntity<ContactDto> saveMassage(ContactDto contactDto);
}
