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
    private Long customerId;
    private LocalDate startDt;
    private String loanType;
    private Double totalLoan;
    private Double amountPaid;
    private Double outstandingAmount;

}