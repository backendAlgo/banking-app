package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotNull(message = "id must not be null")
    private Long id;
    @NotBlank(message = "name should be not blank")
    private String name;
    @NotBlank(message = "name should be not blank")
    @Email(message = "invalid email")
    private String email;
    @NotBlank
    private String password;
    @NotBlank(message = "Mobile number is empty")
    private String mobileNumber;
    @NotBlank(message = "account number must be not blank")
    private String accountNumber;
    @NotNull(message = "account type must be not blank")
    private AccountTypeDto accountTypeDto;
    @NotBlank(message = "address must be not blank")
    private String address;

}
