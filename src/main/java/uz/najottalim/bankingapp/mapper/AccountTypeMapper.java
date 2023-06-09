package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountTypeDTO;
import uz.najottalim.bankingapp.models.AccountType;

@Component
public class AccountTypeMapper {
    public AccountType toEntity(AccountTypeDTO accountTypeDTO){
        if (accountTypeDTO == null) return null;
        return new AccountType(
                accountTypeDTO.getId(),
                accountTypeDTO.getName()
        );
    }

    public AccountTypeDTO toDto(AccountType accountType){
        if (accountType == null) return null;
        return new AccountTypeDTO(
                accountType.getId(),
                accountType.getName()
        );
    }
}
