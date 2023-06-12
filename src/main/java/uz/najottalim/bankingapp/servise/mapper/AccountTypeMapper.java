package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.accountsdto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

public class AccountTypeMapper {
    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),accountType.getName());
    }

    public static AccountType toEntity(AccountTypeDto accountTypeDto) {
        return new AccountType(accountTypeDto.getId(), accountTypeDto.getName());
    }
}
