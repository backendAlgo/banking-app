package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String branchAddress;
    private String password;
    private String accountType;
    private String role;
}
