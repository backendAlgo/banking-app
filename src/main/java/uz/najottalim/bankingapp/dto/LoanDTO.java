package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanDTO {
    private Long id;
    private Long accountId;
    private LocalDate startDate;
    private LoanTypeDTO loanTypeDTO;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}
