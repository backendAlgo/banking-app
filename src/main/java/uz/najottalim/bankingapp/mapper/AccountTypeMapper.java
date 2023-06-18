package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

public class AccountTypeMapper {
    public static AccountType toEntity(AccountTypeDto accountTypeDto){
        return new AccountType(
                accountTypeDto.getId(),
                accountTypeDto.getName()
        );
    }

    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),
                accountType.getName());
    }
}
