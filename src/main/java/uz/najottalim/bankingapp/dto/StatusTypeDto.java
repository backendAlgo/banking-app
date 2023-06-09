package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusTypeDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "name can  not be null")
    private String name;
}
