package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.NoticeDTO;
import uz.najottalim.bankingapp.models.Notice;

@Component
@RequiredArgsConstructor
public class NoticeMapper {
    public Notice toEntity(NoticeDTO noticeDTO){
        if(noticeDTO == null) return null;
        return new Notice(
                noticeDTO.id(),
                noticeDTO.noticeSummary(),
                noticeDTO.noticeDetails(),
                noticeDTO.imageUrl(),
                noticeDTO.createDate()
        );
    }

    public NoticeDTO toDto(Notice notice){
        if(notice == null) return null;
        return new NoticeDTO(
                notice.getId(),
                notice.getTitle(),
                notice.getBody(),
                notice.getImageUrl(),
                notice.getCreateDate()
        );
    }
}
