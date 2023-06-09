package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.MessagesRepository;
import uz.najottalim.bankingapp.service.MessageService;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessageService {

    @Autowired
    private MessagesRepository massagesRepository;
}
