package uz.najottalim.bankingapp.dto.loandto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.LoanType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private Long id;
    private LocalDate startDate;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
    private LoanTypeDto loanTypeDto;
    private AccountDto accountDto;
}
