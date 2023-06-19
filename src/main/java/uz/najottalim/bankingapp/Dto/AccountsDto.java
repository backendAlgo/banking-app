package uz.najottalim.bankingapp.Dto;import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class AccountsDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String accountNumber;
    private AccountTypeDto accountTypeDto;
    private String address;


}
