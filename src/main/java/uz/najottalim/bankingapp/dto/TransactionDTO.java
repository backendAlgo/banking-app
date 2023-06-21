package uz.najottalim.bankingapp.dto;

import java.time.LocalDate;


public record TransactionDTO(
        Long id,
        AccountDTO account,
        LocalDate transactionDt,
        String transactionSummary,
        String transactionType,
        Double transactionAmt,
        Double closingBalance) {
}
