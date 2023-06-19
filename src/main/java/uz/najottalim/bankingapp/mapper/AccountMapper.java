package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.entity.Account;

public class AccountMapper {
    public static Account toEntity(AccountsDto accountsDto){
        return  new Account(
                accountsDto.getId(),
                accountsDto.getName(),
                accountsDto.getEmail(),
                accountsDto.getPassword(),
                accountsDto.getMobileNumber(),
                accountsDto.getAccountNumber(),
                accountsDto.getAddress(),
                AccountTypeMapper.toEntity(accountsDto.getAccountTypeDto()),
                RoleMapper.toEntity(accountsDto.getRole())
        );
    }
    public static AccountsDto toDto(Account account) {
        return new AccountsDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getAddress(),
                RoleMapper.toDto(account.getRoles())

        );
    }
}
