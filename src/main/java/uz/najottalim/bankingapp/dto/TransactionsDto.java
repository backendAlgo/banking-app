package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDto {
    private Long id;
    private AccountDto accountDto;
    private LocalDate transactionDate;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    private Double closingBalance;
}
