package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.noticesdto.NoticeDto;

import java.util.List;

public interface NoticeService {
    ResponseEntity<List<NoticeDto>> getAllNotices();
}
