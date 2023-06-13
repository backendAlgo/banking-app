package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;


public record NoticeDTO (
    Long id,
    String title,
    String body,
    String imageUrl,
    LocalDate createDate){
}
