package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.Entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    private String password;
    private AccountTypeDto accountTypeDTO;
    private String role;

}
