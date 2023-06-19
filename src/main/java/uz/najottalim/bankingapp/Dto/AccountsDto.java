package uz.najottalim.bankingapp.Dto;import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import uz.najottalim.bankingapp.entity.Role;


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
    private RoleDTO role;


//    public AccountsDto(Long id, String name, String email, String password, String mobileNumber, String accountNumber, AccountTypeDto dto, String address, RoleDTO dto1)
//    {
//
//        this.id=id;
//        this.name=name;
//        this.email=email;
//        this.address =address;
//        this.accountTypeDto =dto;
//        this.password=password;
//        this.mobileNumber=mobileNumber;
//        this.accountNumber=accountNumber;
//        this.role=dto1;
//    }
}
