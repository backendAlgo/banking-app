package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.MessageDTO;
import uz.najottalim.bankingapp.models.Message;

@Component
public class MessageMapper {

    public Message toEntity(MessageDTO messageDTO){
        if(messageDTO == null) return null;
        return new Message();
    }

    public MessageDTO toDto(Message message){
        if(message == null) return null;
        return new MessageDTO();
    }
}
