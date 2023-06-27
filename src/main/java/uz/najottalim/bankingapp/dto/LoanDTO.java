package uz.najottalim.bankingapp.dto;

import java.time.LocalDate;

public record LoanDTO(
        Long loanNumber,
        Long customerId,
        LocalDate startDt,
        String loanType,
        Double totalLoan,
        Double amountPaid,
        Double outstandingAmount
) {
}
