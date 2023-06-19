package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

@Component
@RequiredArgsConstructor
public class AccountTypeMapper {
    public AccountType toEntity(AccountTypeDto accountTypeDto){
        if (accountTypeDto == null) return null;
        return new AccountType(
                accountTypeDto.getId(),
                accountTypeDto.getName()
        );
    }

    public AccountTypeDto toDto(AccountType accountType){
        if (accountType == null) return null;
        return new AccountTypeDto(
                accountType.getId(),
                accountType.getName()
        );
    }
}