package uz.najottalim.bankingapp.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.najottalim.bankingapp.model.Account;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private Long id;
    private LocalDate startDate;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
    private AccountDTO accountDTO;

}
