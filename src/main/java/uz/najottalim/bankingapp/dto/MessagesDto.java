package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagesDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "name can  not be null")
    private String name;

    @NotBlank(message = "email can  not be null")
    private String email;

    @NotBlank(message = "subject can  not be null")
    private String subject;

    @NotBlank(message = "message can  not be null")
    private String message;

    @NotBlank(message = "sentDate can  not be null")
    private LocalDate sentDate;

    @NotBlank(message = "statusTypeId can  not be null")
    private Integer statusTypeId;
}
