package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Dto.LoanDTO;
import uz.najottalim.bankingapp.entity.Loan;

public class LoanMapper {


    public static Loan toEntity(LoanDTO loanDTO){
        if(loanDTO == null) return null;
        return new Loan(
                loanDTO.id(),
                loanDTO.startDt(),
                loanDTO.totalLoan(),
                loanDTO.amountPaid(),
                loanDTO.outstandingAmount()
        );
    }

    public static LoanDTO toDto(Loan loan){
        if(loan == null) return null;
        return new LoanDTO(
                loan.getId(),
                loan.getAccount().getId(),
                loan.getStartDate(),
                loan.getLoanType().getName(),
                loan.getTotalLoan(),
                loan.getAmountPay(),
                loan.getOutstandingAmt()
        );
    }
}