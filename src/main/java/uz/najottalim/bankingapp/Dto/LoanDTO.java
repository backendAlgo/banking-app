package uz.najottalim.bankingapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Long id;
    private Long accountId;
    private LocalDate startDate;
    private LoanTypeDTO loanTypeDTO;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}
