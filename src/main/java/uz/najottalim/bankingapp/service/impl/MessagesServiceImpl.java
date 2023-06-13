package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.MessageDTO;
import uz.najottalim.bankingapp.mapper.MessageMapper;
import uz.najottalim.bankingapp.models.Message;
import uz.najottalim.bankingapp.repository.MessageRepository;
import uz.najottalim.bankingapp.service.MessageService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessageService {

    private final MessageRepository massagesRepository;
    private final MessageMapper messageMapper;

    @Override
    public ResponseEntity<MessageDTO> getMessageById(Long id) {
        Optional<Message> optionalMessage = massagesRepository.findById(id);
        if(optionalMessage.isEmpty()){
            throw new NoSuchElementException("message not found");
        }
        return ResponseEntity.ok(
                messageMapper.toDto(optionalMessage.get())
        );
    }

    @Override
    public ResponseEntity<List<MessageDTO>> getAllMessage(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize) {
        PageRequest pageable = null;
        Sort sort = null;
        if(pageNum.isPresent() && pageSize.isPresent()){
            pageable = PageRequest.of(pageNum.get(), pageSize.get());
        }
        if(columnName.isPresent()){
            sort = Sort.by(columnName.get());
            if(pageable != null){
                pageable = PageRequest.of(pageNum.get(),pageSize.get(),Sort.by(columnName.get()));
            }
        }
        if(pageable != null){
            return ResponseEntity.ok(
                    massagesRepository.findAll(pageable)
                            .stream()
                            .map(messageMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        else if(sort != null){
            return ResponseEntity.ok(
                    massagesRepository.findAll(sort)
                            .stream()
                            .map(messageMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        return ResponseEntity.ok(
                massagesRepository.findAll()
                        .stream()
                        .map(messageMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<MessageDTO> addMessage(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public ResponseEntity<MessageDTO> updateMessage(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public ResponseEntity<MessageDTO> deleteMessage(Long id) {
        return null;
    }
}
