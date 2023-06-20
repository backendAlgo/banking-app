package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.messagedto.ContactDto;
import uz.najottalim.bankingapp.servise.ContactService;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactDto> saveMessage(@RequestBody ContactDto contactDto){
        return contactService.saveMassage(contactDto);
    };
}
