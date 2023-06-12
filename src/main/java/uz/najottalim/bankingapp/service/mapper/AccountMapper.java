package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.entity.Account;

public class AccountMapper {
    public static AccountsDto toDto(Account account) {
        return new AccountsDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getAddress()
        );
    }
}
