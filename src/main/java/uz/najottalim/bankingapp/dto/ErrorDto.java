package uz.najottalim.bankingapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String errors;
}
