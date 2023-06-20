package uz.najottalim.bankingapp.Dto;

import lombok.With;


@With
public record AccountsDto(
        Long id,
        String name,
        String email,
        String mobileNumber,
        String accountNumber,
        AccountTypeDto accountTypeDTO,
        String address,
        String password,
        String role
){

}
