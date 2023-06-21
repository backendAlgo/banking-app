package uz.najottalim.bankingapp.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.najottalim.bankingapp.model.Account;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private LocalDate transactionDate;
    private String transactionSummary;

    private String transactionType;
    private Double transactionAmt;
    private Double closingBalance;
    private AccountDTO accountDTO;


//    Long id,
//    AccountDTO account,
//    LocalDate transactionDate,
//    String summary,
//    String transactionType,
//    Double transactionAmt,
//    Double closingBalance)

}
