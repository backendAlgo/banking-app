package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.noticesdto.NoticeDto;
import uz.najottalim.bankingapp.entity.Notice;

public class NoticeMapper {

    public static NoticeDto toDto(Notice notice){
        return new NoticeDto(
                notice.getId(),
                notice.getTitle(),
                notice.getBody(),
                notice.getImageUrl(),
                notice.getCreateDate()
        );
    }
}
