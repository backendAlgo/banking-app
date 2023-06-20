package uz.najottalim.bankingapp.dto.noticesdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {
    private Long id;
    @JsonProperty(value = "noticeSummary")
    private String title;
    @JsonProperty(value = "noticeDetails")
    private String body;
    private String imageUrl;
    private LocalDate createDate;

}
