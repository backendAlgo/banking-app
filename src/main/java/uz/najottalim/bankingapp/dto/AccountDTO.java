package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private AccountTypeDTO accountTypeDTO;
    private String address;
    private String password;
    private Role role;
}
