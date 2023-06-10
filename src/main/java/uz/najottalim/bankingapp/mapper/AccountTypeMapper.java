package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.AccountTypeDTO;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.model.AccountType;

public class AccountTypeMapper {
    public static AccountType toEntity(AccountTypeDTO accountTypeDTO){
        return new AccountType(
                accountTypeDTO.getId(),
                accountTypeDTO.getName()
        );
    }

    public static AccountTypeDTO toDto(AccountType accountType){
        return new AccountTypeDTO(accountType.getId(),
                accountType.getName());
    }
}
