package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.model.Account;

public class AccountMapping {
    public AccountDto toDto(Account account){
        return account == null ? null : new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapping.toDto(account.getAccountType()),
                account.getAddress(),
                RoleMapping.toDto(account.getRole())
        );
    }

    public Account toEntity(AccountDto account){
        return account == null ? null : new Account(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapping.toEntity(account.getAccountTypeDto()),
                account.getAddress(),
                RoleMapping.toEntity(account.getRoleDto())
        );
    }
}
