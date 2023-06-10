package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.NoticeDTO;
import uz.najottalim.bankingapp.mapper.NoticeMapper;
import uz.najottalim.bankingapp.models.Notice;
import uz.najottalim.bankingapp.repository.NoticeRepository;
import uz.najottalim.bankingapp.service.NoticeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    @Override
    public ResponseEntity<NoticeDTO> getNoticeById(Long id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        if(noticeOptional == null){
            throw new NoSuchElementException("notice not found");
        }
        return ResponseEntity.ok(noticeMapper.toDto(noticeOptional.get()));
    }

    @Override
    public ResponseEntity<List<NoticeDTO>> getAllNotice(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize) {
        PageRequest pageable = null;
        Sort sort = null;
        if(pageNum.isPresent() && pageSize.isPresent()){
            pageable = PageRequest.of(pageNum.get(), pageSize.get());
        }
        if(columnName.isPresent()){
            sort = Sort.by(columnName.get());
            if(pageable != null){
                pageable = PageRequest.of(pageNum.get(),pageSize.get(),Sort.by(columnName.get()));
            }
        }
        if(pageable != null){
            return ResponseEntity.ok(
                    noticeRepository.findAll(pageable)
                            .stream()
                            .map(noticeMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        else if(sort != null){
            return ResponseEntity.ok(
                    noticeRepository.findAll(sort)
                            .stream()
                            .map(noticeMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        return ResponseEntity.ok(
                noticeRepository.findAll()
                        .stream()
                        .map(noticeMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<NoticeDTO> addNotice(NoticeDTO noticeDTO) {
        return null;
    }

    @Override
    public ResponseEntity<NoticeDTO> updateNotice(NoticeDTO noticeDTO) {
        return null;
    }

    @Override
    public ResponseEntity<NoticeDTO> deleteNotice(Long id) {
        return null;
    }
}
