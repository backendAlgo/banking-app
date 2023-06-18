package uz.najottalim.bankingapp.dto;
import lombok.*;

import javax.persistence.*;

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
    private AccountTypeDto accountTypeDto;
    private RoleDto roleDto;

    // Constructors, getters, and setters
}

