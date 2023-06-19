package uz.najottalim.bankingapp.errorDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String errors;
}
