package uz.najottalim.bankingapp.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String errors;
}