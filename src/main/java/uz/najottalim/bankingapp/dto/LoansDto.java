package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {
    private Long id;
    private AccountDto accountDto;
    private LocalDate startDate;
    private LoansTypeDto loansTypeDto;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}