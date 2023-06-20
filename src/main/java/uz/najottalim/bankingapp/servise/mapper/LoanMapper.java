package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.loandto.LoanDto;
import uz.najottalim.bankingapp.entity.Loan;

public class LoanMapper {
    public static LoanDto toDto(Loan loan){
        return new LoanDto(
                loan.getId(),
                loan.getStartDate(),
                loan.getTotalLoan(),
                loan.getAmountPay(),
                loan.getOutstandingAmt(),
                loan.getLoanType().getName(),
                loan.getAccount().getId()
        );
    }

}
