package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDTO {
    private Long id;
    private String title;
    private String body;
    private String imageUrl;
    private LocalDate sentDate;
}
