package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Role;
@With
public record AccountDTO (
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
