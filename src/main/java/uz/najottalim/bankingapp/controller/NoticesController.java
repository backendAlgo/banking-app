package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.NoticeDTO;
import uz.najottalim.bankingapp.service.NoticeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notices")
@Slf4j
@RequiredArgsConstructor
public class NoticesController {

    private final NoticeService noticeService;

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDTO> getNoticeById(@PathVariable Long id) {
        return noticeService.getNoticeById(id);
    }
    @GetMapping("/check")
    public String check() {
        return "notices page";
    }
    @GetMapping
    public ResponseEntity<List<NoticeDTO>> getAllNotice(@RequestParam Optional<String> columnName,
                                                        @RequestParam Optional<Integer> pageNum,
                                                        @RequestParam Optional<Integer> pageSize) {
        return noticeService.getAllNotice(columnName,pageNum,pageSize);
    }

    @PostMapping
    public ResponseEntity<NoticeDTO> addNotice(@RequestBody NoticeDTO noticeDTO){
        return noticeService.addNotice(noticeDTO);
    }

    @PutMapping
    public ResponseEntity<NoticeDTO> updateNotice(@RequestBody NoticeDTO noticeDTO){
        return noticeService.updateNotice(noticeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NoticeDTO> deleteNotice(@PathVariable Long id){
        return noticeService.deleteNotice(id);
    }

}
