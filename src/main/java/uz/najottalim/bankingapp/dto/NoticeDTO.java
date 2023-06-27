package uz.najottalim.bankingapp.dto;

import java.time.LocalDate;

public record NoticeDTO(
        Long id,
        String noticeSummary,
        String noticeDetails,
        String imageUrl,
        LocalDate createDate
) {
}
