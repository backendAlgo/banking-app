package uz.najottalim.bankingapp.dto;

import lombok.With;
@With
public record AccountDTO(
        Long customerId,
        Long id,
        String name,
        String email,
        String mobileNumber,
        String accountNumber,
        AccountTypeDTO accountTypeDTO,
        String address,
        String password,
        String role
){

}

