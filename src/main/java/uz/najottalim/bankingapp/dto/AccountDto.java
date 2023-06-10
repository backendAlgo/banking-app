package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private AccountTypeDto accountTypeDTO;
    private String address;
    private String password;
}
