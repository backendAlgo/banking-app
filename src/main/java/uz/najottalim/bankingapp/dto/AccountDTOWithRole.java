package uz.najottalim.bankingapp.dto;

public record AccountDTOWithRole(
        Long id,
        String name,
        String email,
        String mobileNumber,
        String accountNumber,
        String role_id,
        String address,
        String password
) {
}
