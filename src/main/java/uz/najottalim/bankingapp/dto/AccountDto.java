package uz.najottalim.bankingapp.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    @NotBlank(message = "id can  not be null")
    private Long id;
    @NotBlank(message = "name can  not be null")
    private String name;
    @NotBlank(message = "email can  not be null")
    private String email;
    @NotBlank(message = "mobileNumber can  not be null")
    private String mobileNumber;
    @NotBlank(message = "accountNumber can  not be null")
    private String accountNumber;
    @NotBlank(message = "accountTypeDto can  not be null")
    private AccountTypeDto accountTypeDto;
    @NotBlank(message = "address can  not be null")
    private String address;
    @NotBlank(message = "password can not be null")
    private String password;
}

