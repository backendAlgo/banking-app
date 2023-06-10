package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeDto {
    private Long id;
    private String title;
    private String body;
    private String imageUrl;
    private LocalDate createDate;
}
