package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.StatusTypeDTO;
import uz.najottalim.bankingapp.models.StatusType;

@Component
@RequiredArgsConstructor
public class StatusTypeMapper {

    public StatusType toEntity(StatusTypeDTO statusTypeDTO){
        if(statusTypeDTO == null) return null;
        return new StatusType(
                statusTypeDTO.id(),
                statusTypeDTO.name()
        );
    }

    public StatusTypeDTO toDto(StatusType statusType){
        if(statusType == null) return null;
        return new StatusTypeDTO(
                statusType.getId(),
                statusType.getName()
        );
    }
}
