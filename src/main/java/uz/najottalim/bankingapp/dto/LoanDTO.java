package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Account;

import java.time.LocalDate;


public record LoanDTO (
    Long id,
    Account account,
    LocalDate startDate,
    LoanTypeDTO loanTypeDTO,
    Double totalLoan,
    Double amountPay,
    Double outstandingAmt){
}
