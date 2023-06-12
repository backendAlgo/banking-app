package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.models.Account;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    private final AccountTypeMapper accountTypeMapper;
    public Account toEntity(AccountDTO accountDTO){
        if(accountDTO == null) return null;
        return new Account(
                accountDTO.getId(),
                accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getMobileNumber(),
                accountDTO.getAccountNumber(),
                accountTypeMapper.toEntity(accountDTO.getAccountTypeDTO()),
                accountDTO.getAddress(),
                accountDTO.getPassword(),
                null
        );
    }

    public AccountDTO toDto(Account account){
        if(account == null) return null;
        return new AccountDTO(
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
