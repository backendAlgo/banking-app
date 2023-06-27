package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.LoanTypeDTO;
import uz.najottalim.bankingapp.models.LoanType;

@Component
@RequiredArgsConstructor
public class LoanTypeMapper {

    public LoanType toEntity(LoanTypeDTO loanTypeDTO){
        if(loanTypeDTO == null) return null;
        return new LoanType(
                loanTypeDTO.id(),
                loanTypeDTO.name()
        );
    }

    public LoanTypeDTO toDto(LoanType loanType){
        if(loanType == null) return null;
        return new LoanTypeDTO(
                loanType.getId(),
                loanType.getName()
        );
    }
}
