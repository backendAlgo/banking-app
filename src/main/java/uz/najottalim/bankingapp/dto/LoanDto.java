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
public class LoanDto {
    private Long id;
    private Long accountId;
    private LocalDate startDate;
    private LoanTypeDto loanTypeDTO;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}