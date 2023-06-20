package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.LoanDTO;
import uz.najottalim.bankingapp.Dto.LoanDTO;
import uz.najottalim.bankingapp.entity.Loan;
import uz.najottalim.bankingapp.entity.Loan;

public class LoanMapper {


    public static Loan toEntity(LoanDTO loanDTO){
        if(loanDTO == null) return null;
        return new Loan(
                loanDTO.id(),
                loanDTO.startDate(),
                loanDTO.totalLoan(),
                loanDTO.amountPay(),
                loanDTO.outstandingAmt()
        );
    }

    public static LoanDTO toDto(Loan loan){
        if(loan == null) return null;
        return new LoanDTO(
                loan.getId(),
                loan.getAccount(),
                loan.getStartDate(),
                LoanTypeMapper.toDto(loan.getLoanType()),
                loan.getTotalLoan(),
                loan.getAmountPay(),
                loan.getOutstandingAmt()
        );
    }
}