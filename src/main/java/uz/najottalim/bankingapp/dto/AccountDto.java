package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    @NotBlank(message = "name should be not blank")
    private String name;
    @NotBlank(message = "name should be not blank")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "Mobile number is empty")
    private String mobileNumber;
    private String accountNumber;
    private AccountTypeDto accountTypeDto;
    private String address;
}
