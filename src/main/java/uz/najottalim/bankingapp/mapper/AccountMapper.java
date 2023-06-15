package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.models.Account;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    private final AccountTypeMapper accountTypeMapper;
    private final RoleMapper roleMapper;
    public Account toEntity(AccountDTO accountDTO){
        if(accountDTO == null) return null;
        return new Account(
                accountDTO.id(),
                accountDTO.name(),
                accountDTO.email(),
                accountDTO.mobileNumber(),
                accountDTO.accountNumber(),
                accountTypeMapper.toEntity(accountDTO.accountTypeDTO()),
                accountDTO.address(),
                accountDTO.password(),
                roleMapper.toEntity(accountDTO.role())
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
                null,
                roleMapper.toDto(account.getRole())
        );
    }
}
