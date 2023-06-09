package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "title can  not be null")
    private String title;

    @NotBlank(message = "body can  not be null")
    private String body;

    @NotBlank(message = "imageUrl can  not be null")
    private String imageUrl;

    @NotBlank(message = "createDate can  not be null")
    private LocalDate createDate;
}
