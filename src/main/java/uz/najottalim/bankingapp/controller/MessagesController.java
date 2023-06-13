package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.MessageDTO;
import uz.najottalim.bankingapp.service.MessageService;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("massages")
@Slf4j
@RequiredArgsConstructor
public class MessagesController {

    private final MessageService messageService;

    @GetMapping("/{id}")
    private ResponseEntity<MessageDTO> getMessageById(@PathVariable Long id){
        return messageService.getMessageById(id);
    }

    @GetMapping
    private ResponseEntity<List<MessageDTO>> getAllMessage(@RequestParam Optional<Integer> pageNum,
                                                           @RequestParam Optional<Integer> pageSize,
                                                           @RequestParam Optional<String> columnName){
        return messageService.getAllMessage(columnName,pageNum,pageSize);
    }

    @PostMapping
    public ResponseEntity<MessageDTO> addMessage(@RequestBody MessageDTO messageDTO){
        return messageService.addMessage(messageDTO);
    }

    @PutMapping
    public ResponseEntity<MessageDTO> updateMessage(@RequestBody MessageDTO messageDTO){
        return messageService.updateMessage(messageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteMessage(@PathVariable Long id){
        return messageService.deleteMessage(id);
    }

}
