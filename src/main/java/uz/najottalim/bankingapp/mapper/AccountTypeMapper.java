package uz.najottalim.bankingapp.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.Entity.AccountType;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.AccountTypeDto;

@Component
@RequiredArgsConstructor
public class AccountTypeMapper {
    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),accountType.getName());
    }
}
