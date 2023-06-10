package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.MessageDTO;
import uz.najottalim.bankingapp.models.Message;

@Component
@RequiredArgsConstructor
public class MessageMapper {

    public final StatusTypeMapper statusTypeMapper;

    public Message toEntity(MessageDTO messageDTO){
        if(messageDTO == null) return null;
        return new Message(
                messageDTO.getId(),
                messageDTO.getName(),
                messageDTO.getEmail(),
                messageDTO.getSubject(),
                messageDTO.getMessage(),
                messageDTO.getSentDate(),
                statusTypeMapper.toEntity(messageDTO.getStatusTypeDTO())

        );
    }

    public MessageDTO toDto(Message message){
        if(message == null) return null;
        return new MessageDTO(
                message.getId(),
                message.getName(),
                message.getEmail(),
                message.getSubject(),
                message.getMessage(),
                message.getSentDate(),
                statusTypeMapper.toDto(message.getStatusType())
        );
    }
}
