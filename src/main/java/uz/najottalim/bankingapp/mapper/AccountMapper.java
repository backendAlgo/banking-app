package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountsDTO;
import uz.najottalim.bankingapp.models.Accounts;

@Component
public class AccountMapper {
    public Accounts toEntity(AccountsDTO accountsDTO){
        if(accountsDTO == null) return null;
        return new Accounts(
                accountsDTO.getId(),
                accountsDTO.getName(),
                accountsDTO.getEmail(),
                accountsDTO.getMobileNumber(),
                accountsDTO.getAccountNumber(),
                accountsDTO.getAccountTypeNumber(),
                accountsDTO.getAddress()
        );
    }

    public AccountsDTO toDto(Accounts accounts){
        if(accounts == null) return null;
        return new AccountsDTO(
                accounts.getId(),
                accounts.getName(),
                accounts.getEmail(),
                accounts.getMobileNumber(),
                accounts.getAccountNumber(),
                accounts.getAccountTypeNumber(),
                accounts.getAddress()
        );
    }
}
