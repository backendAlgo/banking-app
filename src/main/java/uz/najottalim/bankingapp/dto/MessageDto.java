package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MessageDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate sentDate;
}
