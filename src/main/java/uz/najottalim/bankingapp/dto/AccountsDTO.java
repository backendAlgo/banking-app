package uz.najottalim.bankingapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountsDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private Long accountTypeNumber;
    private String address;
}
