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
    private Long customerId;
    private LocalDate startDt;
    private String loanType;
    private Double totalLoan;
    private Double amountPaid;
    private Double outstandingAmount;


}
