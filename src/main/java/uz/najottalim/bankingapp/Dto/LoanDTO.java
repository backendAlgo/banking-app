package uz.najottalim.bankingapp.Dto;

import java.time.LocalDate;


public record LoanDTO (
        Long id,
        Long customerId,
        LocalDate startDt,
        String loanType,
        Double totalLoan,
        Double amountPaid,
        Double outstandingAmount){
}
