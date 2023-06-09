package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessagesDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate sendDate;
    private StatusTypeDto statusTypeDto;
}
