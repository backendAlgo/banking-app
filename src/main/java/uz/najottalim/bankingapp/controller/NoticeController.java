package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.noticesdto.NoticeDto;
import uz.najottalim.bankingapp.servise.NoticeService;

import java.util.*;

@RestController
@RequestMapping("notices")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    @GetMapping()
    public ResponseEntity<List<NoticeDto>> getAllNotices(){
        return noticeService.getAllNotices();
    }

}
