package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.noticesdto.NoticeDto;
import uz.najottalim.bankingapp.repository.NoticeRepository;
import uz.najottalim.bankingapp.servise.NoticeService;
import uz.najottalim.bankingapp.servise.mapper.NoticeMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    @Override
    public ResponseEntity<List<NoticeDto>> getAllNotices() {
        return ResponseEntity.ok(noticeRepository.findAll()
                .stream()
                .map(NoticeMapper::toDto)
                .collect(Collectors.toList()));
    }
}
