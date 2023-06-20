package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.AccountTypeDto;
import uz.najottalim.bankingapp.Dto.AccountTypeDto;
import uz.najottalim.bankingapp.Dto.LoanDTO;
import uz.najottalim.bankingapp.Dto.LoanTypeDTO;
import uz.najottalim.bankingapp.entity.AccountType;
import uz.najottalim.bankingapp.entity.AccountType;
import uz.najottalim.bankingapp.entity.Loan;
import uz.najottalim.bankingapp.entity.LoanType;

public class LoanTypeMapper {
    public LoanType toEntity(LoanTypeDTO loanTypeDTO){
        if(loanTypeDTO == null) return null;
        return new LoanType(
                loanTypeDTO.getId(),
                loanTypeDTO.getName()
        );
    }

    public static  LoanTypeDTO toDto(LoanType loanType){
        if(loanType == null) return null;
        return new LoanTypeDTO(
                loanType.getId(),
                loanType.getName()
        );
    }
}
