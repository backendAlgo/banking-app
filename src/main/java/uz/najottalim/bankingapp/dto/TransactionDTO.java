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
    private LocalDate transaction_date;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    private Double closingBalance;
    private AccountDTO accountDTO;

}
