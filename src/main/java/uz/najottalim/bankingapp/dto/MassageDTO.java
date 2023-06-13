package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MassageDTO {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate sentDate;
}
