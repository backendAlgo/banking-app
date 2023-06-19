package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    private final AccountTypeMapper accountTypeMapper;
    public Account toEntity(AccountDto accountDTO){
        if(accountDTO == null) return null;
        return new Account(
                accountDTO.getId(),
                accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getMobileNumber(),
                accountDTO.getAccountNumber(),
                accountTypeMapper.toEntity(accountDTO.getAccountTypeDto()),
                accountDTO.getAddress(),
                accountDTO.getPassword()
        );
    }

    public AccountDto toDto(Account account){
        if(account == null) return null;
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                accountTypeMapper.toDto(account.getAccountType()),
                account.getAddress(),
                null
        );
    }
}
