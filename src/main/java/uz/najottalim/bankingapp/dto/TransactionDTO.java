package uz.najottalim.bankingapp.dto;

import java.time.LocalDate;

public record TransactionDTO(
        Long customerId,
        AccountDTO account,
        LocalDate transactionDt,
        String transactionSummary,
        String transactionType,
        Double transactionAmt,
        Double closingBalance
) {
}
