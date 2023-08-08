package uz.najottalim.bankingapp.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Entity.AccountType;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.AccountTypeDto;

@Component
@RequiredArgsConstructor
public class AccountTypeMapper {
    public static AccountType toEntity(AccountTypeDto accountTypeDTO){
        return new AccountType(
                accountTypeDTO.getId(),
                accountTypeDTO.getName()
        );
    }

    public static AccountTypeDto toDto(AccountType accountType){
        return new AccountTypeDto(accountType.getId(),
                accountType.getName());
    }
}
