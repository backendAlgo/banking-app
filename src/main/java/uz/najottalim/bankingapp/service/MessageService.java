package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    ResponseEntity<MessageDTO> getMessageById(Long id);

    ResponseEntity<List<MessageDTO>> getAllMessage(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize);

    ResponseEntity<MessageDTO> addMessage(MessageDTO messageDTO);

    ResponseEntity<MessageDTO> updateMessage(MessageDTO messageDTO);

    ResponseEntity<MessageDTO> deleteMessage(Long id);
}
