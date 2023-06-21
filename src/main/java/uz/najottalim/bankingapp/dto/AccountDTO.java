package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.model.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    private String password;
    private AccountTypeDTO accountTypeDTO;
    String role;


}
