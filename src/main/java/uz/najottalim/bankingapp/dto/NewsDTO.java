package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewsDTO {
    private Long id;
    private String title;
    private String body;
    private String imageUrl;
    private LocalDate createDate;
}
