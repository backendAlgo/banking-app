package uz.najottalim.bankingapp.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.model.Account;


public class AccountMapper {

    public static Account toEntity(AccountDTO accountDTO){
        return new Account(accountDTO.getId(),
                accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getMobileNumber(),
                accountDTO.getAccountNumber(),
                accountDTO.getAddress(),
                accountDTO.getPassword(),
                AccountTypeMapper.toEntity(accountDTO.getAccountTypeDTO()),
                RoleMapper.toEntity(accountDTO.getRoleDTO())
        );
    }
    public static AccountDTO toDto(Account account){
        return new AccountDTO(account.getId(),
                account.getName(),
                account.getEmail(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                account.getAddress(),
                account.getPassword(),
                AccountTypeMapper.toDto(account.getAccountType()),
                RoleMapper.toDto(account.getRole()));


    }

}
