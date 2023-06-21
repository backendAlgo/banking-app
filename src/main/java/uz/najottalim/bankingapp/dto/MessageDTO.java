package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

public record MessageDTO (
    Long contactId,
    String contactName,
    String contactEmail,
    String subject,
    String message,
    LocalDate sentDate,
    StatusTypeDTO statusTypeDTO){
}
