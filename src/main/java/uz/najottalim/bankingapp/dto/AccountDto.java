package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.entity.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private AccountTypeDto accountTypeDto;
    private String address;
}
