package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDto {
    private Long id;
    private LocalDate transactionDate;
    private String transactionSummary;

    private String transactionType;
    private Double transactionAmt;
    private Double closingBalance;
    private AccountDto accountDTO;
}
