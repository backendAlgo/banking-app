package uz.najottalim.bankingapp.dto.accountsdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    /**public customerId: number;
     public accountNumber: number;
     public accountType: string;
     public branchAddress: string;
     **/
    @JsonProperty(value = "customerId")
    private Long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String mobileNumber;
    private String accountNumber;
    private String accountType;
    private String branchAddress;
    private RoleDto roleDto;
}
