package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.AccountTypeDto;
import uz.najottalim.bankingapp.model.AccountType;

import java.util.Collections;

public class AccountTypeMapping {
    public static AccountTypeDto toDto(AccountType accountType) {
        return accountType == null ? null : new AccountTypeDto(
                accountType.getId(),
                accountType.getName()
        );
    }

    public static AccountType toEntity(AccountTypeDto accountTypeDto) {
        return accountTypeDto == null ? null : new AccountType(
                accountTypeDto.getId(),
                accountTypeDto.getName(),
                Collections.emptyList()
        );
    }

}
