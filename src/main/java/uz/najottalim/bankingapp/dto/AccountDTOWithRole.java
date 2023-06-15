package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public record AccountDTOWithRole(
        Long id,
        String name,
        String email,
        String mobileNumber,
        String accountNumber,
        String role_id,
        String address,
        String password) {
}
