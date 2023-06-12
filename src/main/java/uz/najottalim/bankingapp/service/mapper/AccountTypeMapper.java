package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.dto.accountsDTO.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

public class AccountTypeMapper {
    public static AccountTypeDto dto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(), accountType.getName());
    }
}
