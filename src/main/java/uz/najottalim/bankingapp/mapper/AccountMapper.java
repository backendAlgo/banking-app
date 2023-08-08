package uz.najottalim.bankingapp.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.dto.AccountDto;

public class AccountMapper {

    public static Account toEntity(AccountDto accountDTO){

        return new Account(accountDTO.getId(),
                accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getMobileNumber(),
                accountDTO.getAccountNumber(),
                accountDTO.getAddress(),
                accountDTO.getPassword(),
                AccountTypeMapper.toEntity(accountDTO.getAccountTypeDTO()),
                null
        );

    }
    public static AccountDto toDto(Account account){
        return new AccountDto(account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                account.getAddress(),
                null,
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getRole().getName());


    }
}
