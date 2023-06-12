package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.Dto.AccountTypeDto;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.AccountType;

public class AccountTypeMapper {
    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),accountType.getName());
    }
}
