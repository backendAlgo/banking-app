package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Account;

import java.time.LocalDate;


public record TransactionDTO(
        Long id,
        AccountDTO account,
        LocalDate transactionDate,
        String summary,
        String transactionType,
        Double transactionAmt,
        Double closingBalance) {
}
