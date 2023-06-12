package uz.najottalim.bankingapp.service.mapper;


import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;
import uz.najottalim.bankingapp.entity.Accounts;
import uz.najottalim.bankingapp.entity.Role;

public class AccountMapper {
    public static AccountDto dto(Accounts accounts){
        return new AccountDto(
                accounts.getId(),
                accounts.getName(),
                accounts.getEmail(),
                accounts.getMobileNumber(),
                accounts.getAccountNumber(),
                accounts.getAccountTypeId(),
                accounts.getAccountType(),
                accounts.getAddres(),
                RoleMapper.toDto(accounts.getRole()));
    }


}
