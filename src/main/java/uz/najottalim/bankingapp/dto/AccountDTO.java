package uz.najottalim.bankingapp.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.najottalim.bankingapp.model.AccountType;

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
    private AccountTypeDTO accountTypeDTO;


}
