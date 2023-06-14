package uz.najottalim.bankingapp.servise.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
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
                AccountTypeMapper.toDto(account.getAccountType()),
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
                AccountTypeMapper.toEntity(accountDto.getAccountTypeDto()),
                accountDto.getAddress(),
                RoleMapper.toEntity(accountDto.getRoleDto()));
    }
}