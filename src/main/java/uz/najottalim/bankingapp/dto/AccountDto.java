package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;
    @NotBlank(message = "name can  not be null")
    private String name;
    @NotBlank(message = "email can  not be null")
    private String email;
    @NotBlank(message = "mobileNumber can  not be null")
    private String mobileNumber;
    @NotBlank(message = "accountNumber can  not be null")
    private String accountNumber;
    @NotBlank(message = "accountTypeId can  not be null")
    private Integer accountTypeId;
    @NotBlank(message = "address can  not be null")
    private String address;
}
