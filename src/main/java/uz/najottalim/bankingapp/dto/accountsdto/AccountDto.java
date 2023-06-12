package uz.najottalim.bankingapp.dto.accountsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String accountNumber;
    private AccountTypeDto accountTypeDto;
    private String address;
    private RoleDto roleDto;
}
