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
    private Long accountId;
    private LocalDate transactionDate;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    private Double closingBalance;
}