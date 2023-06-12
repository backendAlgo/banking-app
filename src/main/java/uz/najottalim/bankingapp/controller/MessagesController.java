package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.service.MessagesService;

@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessagesController {
    private final MessagesService messagesService;

}
