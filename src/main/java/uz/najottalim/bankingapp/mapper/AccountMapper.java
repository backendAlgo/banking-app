package uz.najottalim.bankingapp.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.dto.AccountDto;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    private final AccountTypeMapper accountTypeMapper;

    public static AccountDto toDto(Account account){
        if(account == null) return  null;
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getAddress(),
                account.getAccountNumber(),
                account.getMobileNumber(),
                AccountTypeMapper.toDto(account.getAccountType()),
                account.getPassword(),
                account.getRole());
    }
}
