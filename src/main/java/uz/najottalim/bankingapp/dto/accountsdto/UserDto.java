package uz.najottalim.bankingapp.dto.accountsdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    /**  User model of front:
     *   public id: number;
     *   public name: string;
     *   public mobileNumber: string;
     *   public email : string;
     *   public password: string;
     *   public role : string;
     *   public statusCd: string;
     *   public statusMsg : string;
     *   public authStatus : string;
     **/
    private Long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String mobileNumber;
    private String accountNumber;
    private String accountType;
    private String address;
    private String role;
}
