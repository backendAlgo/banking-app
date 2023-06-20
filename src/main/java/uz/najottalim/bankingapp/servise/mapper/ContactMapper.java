package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.messagedto.ContactDto;
import uz.najottalim.bankingapp.entity.Contact;
import uz.najottalim.bankingapp.entity.MessagesStatusType;

import java.time.LocalDate;

public class ContactMapper {

    public static Contact toEntity(ContactDto contactDto, MessagesStatusType massagesStatusType){
        return new Contact(
                contactDto.getId(),
                contactDto.getName(),
                contactDto.getEmail(),
                contactDto.getSubject(),
                contactDto.getMessage(),
                LocalDate.now(),
                massagesStatusType
        );
    }

    public static ContactDto toDto(Contact contact){
        return new ContactDto(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getSentDate()
        );
    }
}
