package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Entity.Loan;
import uz.najottalim.bankingapp.dto.LoanDto;

public class LoanMapper {
    public static LoanDto toDto(Loan loan){
        return new LoanDto(
                null,
                loan.getAccount().getId(),
                loan.getStartDate(),
                loan.getLoanType().getName(),
                loan.getTotalLoan(),
                loan.getAmountPay(),
                loan.getOutstandingAmt()
        );
    }
}
