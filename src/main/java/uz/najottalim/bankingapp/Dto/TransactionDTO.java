package uz.najottalim.bankingapp.Dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    private Long customerId;
    AccountsDto accountNumber;
    private LocalDate transactionDt;
    private String transactionSummary;
    String transactionType;
    Double transactionAmt;
    private Double closingBalance;
}
