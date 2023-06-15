package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

public record MessageDTO (
    Long id,
    String name,
    String email,
    String subject,
    String message,
    LocalDate sentDate,
    StatusTypeDTO statusTypeDTO){
}
