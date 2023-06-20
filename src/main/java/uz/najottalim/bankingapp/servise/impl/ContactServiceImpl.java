package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.messagedto.ContactDto;
import uz.najottalim.bankingapp.entity.Contact;
import uz.najottalim.bankingapp.entity.MessagesStatusType;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.ContactRepository;
import uz.najottalim.bankingapp.repository.MessageStatusTypeRepository;
import uz.najottalim.bankingapp.servise.ContactService;
import uz.najottalim.bankingapp.servise.mapper.ContactMapper;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final MessageStatusTypeRepository messageStatusTypeRepository;
    @Override
    public ResponseEntity<ContactDto> saveMassage(ContactDto contactDto) {
        MessagesStatusType messagesStatusType = messageStatusTypeRepository.
                findById(1L).orElseThrow(() -> new NoResourceFoundException(""));

        Contact save = contactRepository.save(ContactMapper.toEntity(contactDto, messagesStatusType));

        return ResponseEntity.ok(ContactMapper.toDto(save));
    }
}
