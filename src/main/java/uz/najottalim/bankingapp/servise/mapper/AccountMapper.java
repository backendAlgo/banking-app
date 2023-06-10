package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getAddress());
    }
}
