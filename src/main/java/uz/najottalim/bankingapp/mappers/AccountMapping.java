package uz.najottalim.bankingapp.mappers;

import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.Account;

public class AccountMapping {
    public AccountDto toDto(Account account){
        return account == null ? null : new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapping.toDto(account.getAccountType()),
                account.getAddress()
        );
    }

    public Account toEntity(AccountDto account){
        return account == null ? null : new Account(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapping.toEntity(account.getAccountTypeDto()),
                account.getAddress()
        );
    }
}
