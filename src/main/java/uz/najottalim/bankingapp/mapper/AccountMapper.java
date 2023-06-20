package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.entity.Account;

public class AccountMapper {
    public static Account toEntity(AccountsDto accountDTO) {
        if (accountDTO == null) return null;
        return new Account(
                accountDTO.id(),
                accountDTO.name(),
                accountDTO.email(),
                accountDTO.mobileNumber(),
                accountDTO.accountNumber(),
                AccountTypeMapper.toEntity(accountDTO.accountTypeDTO()),
                accountDTO.address(),
                accountDTO.password(),
                null);
    }
    public static AccountsDto toDto(Account account) {
        return new AccountsDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getAddress(),
                null,
               account.getRoles().getName()
        );
    }
}
