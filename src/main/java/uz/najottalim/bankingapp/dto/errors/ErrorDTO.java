package uz.najottalim.bankingapp.dto.errors;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String errors;
}
