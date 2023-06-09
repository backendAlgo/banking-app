package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.MessagesDTO;
import uz.najottalim.bankingapp.models.Messages;

@Component
public class MessagesMapper {

    public Messages toEntity(MessagesDTO messagesDTO){
        if(messagesDTO == null) return null;
        return new Messages();
    }

    public MessagesDTO toDto(Messages messages){
        if(messages == null) return null;
        return new MessagesDTO();
    }
}
