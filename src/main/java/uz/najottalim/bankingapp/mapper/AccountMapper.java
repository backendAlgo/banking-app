package uz.najottalim.bankingapp.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.entity.Account;

@Service
public class AccountMapper {
    public static Account toEntity(AccountDTO accountDTO){
        return new Account(accountDTO.getId(),
                accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getMobileNumber(),
                accountDTO.getAccountNumber(),
                accountDTO.getAddress(),
                accountDTO.getPassword(),
                AccountTypeMapper.toEntity(accountDTO.getAccountTypeDto()),
                RoleMapper.toEntity(accountDTO.getRoleDto())
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
