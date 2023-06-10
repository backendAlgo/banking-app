package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.NoticeDTO;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    ResponseEntity<NoticeDTO> getNoticeById(Long id);

    ResponseEntity<List<NoticeDTO>> getAllNotice(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize);

    ResponseEntity<NoticeDTO> addNotice(NoticeDTO noticeDTO);

    ResponseEntity<NoticeDTO> updateNotice(NoticeDTO noticeDTO);

    ResponseEntity<NoticeDTO> deleteNotice(Long id);
}
