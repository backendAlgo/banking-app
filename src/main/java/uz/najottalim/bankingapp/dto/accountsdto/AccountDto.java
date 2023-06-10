package uz.najottalim.bankingapp.dto.accountsdto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountTypeDto.AccountTypeDto;
import uz.najottalim.bankingapp.entity.AccountType;

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
}
