package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Account;

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
