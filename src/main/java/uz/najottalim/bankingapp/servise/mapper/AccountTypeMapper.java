package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.accountTypeDto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

public class AccountTypeMapper {
    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),accountType.getName());
    }
}
