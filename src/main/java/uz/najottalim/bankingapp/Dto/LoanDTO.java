package uz.najottalim.bankingapp.Dto;

import lombok.*;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.Account;

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
