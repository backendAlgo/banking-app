package uz.najottalim.bankingapp.servise.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.dto.accountsdto.AccountTypeDto;
import uz.najottalim.bankingapp.dto.accountsdto.UserDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.Role;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.RoleRepository;

import java.util.Optional;

@Service
public class AccountMapper {
    public static AccountDto toDto(Account account){

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

    public static Account toEntity(AccountDto accountDto){
        return new Account(accountDto.getId(),
                accountDto.getName(),
                accountDto.getEmail(),
                accountDto.getPassword(),
                accountDto.getMobileNumber(),
                accountDto.getAccountNumber(),
                null,//AccountTypeMapper.toEntity(accountDto.getAccountTypeDto()),
                accountDto.getBranchAddress(),
                RoleMapper.toEntity(accountDto.getRoleDto()));
    }

    public static UserDto toUserDto(Account account){
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
