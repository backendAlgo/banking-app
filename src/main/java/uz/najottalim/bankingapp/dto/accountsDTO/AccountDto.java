package uz.najottalim.bankingapp.dto.accountsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.entity.AccountType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private Long accountTypeId;
    private AccountType accountType;
    private String addres;
    private RoleDto roleDto;

}
