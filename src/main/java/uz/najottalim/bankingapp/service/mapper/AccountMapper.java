package uz.najottalim.bankingapp.service.mapper;


import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;
import uz.najottalim.bankingapp.dto.accountsDTO.UserDto;
import uz.najottalim.bankingapp.entity.Accounts;
import uz.najottalim.bankingapp.entity.Role;

@Service
public class AccountMapper {
    public static AccountDto toDto(Accounts account){

        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                account.getAccountType().getName(),
                account.getAddress(),
                RoleMapper.toDtoWithAuthorities(account.getRole()));
    }

    public static Accounts toEntity(AccountDto accountDto){
        return new Accounts(accountDto.getId(),
                accountDto.getName(),
                accountDto.getEmail(),
                accountDto.getPassword(),
                accountDto.getMobileNumber(),
                accountDto.getAccountNumber(),
                null,//AccountTypeMapper.toEntity(accountDto.getAccountTypeDto()),
                accountDto.getBranchAddress(),
                RoleMapper.toEntity(accountDto.getRoleDto()));
    }

    public static UserDto toUserDto(Accounts account){
        return new UserDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getMobileNumber(),
                account.getAccountNumber(),
                account.getAccountType().getName(),
                account.getAddress(),
                account.getRole().getName()
        );
    }
}
}
