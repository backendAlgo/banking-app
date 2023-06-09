package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.NoticeDTO;
import uz.najottalim.bankingapp.models.Notice;

@Component
public class NoticeMapper {
    public Notice toEntity(NoticeDTO noticeDTO){
        if(noticeDTO == null) return null;
        return new Notice();
    }

    public NoticeDTO toDto(Notice notice){
        if(notice == null) return null;
        return new NoticeDTO();
    }
}
