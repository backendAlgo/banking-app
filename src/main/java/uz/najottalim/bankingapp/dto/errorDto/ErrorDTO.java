package uz.najottalim.bankingapp.dto.errorDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String errors;
}
