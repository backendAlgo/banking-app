package uz.najottalim.bankingapp.mapper;


import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.model.Loan;

public class LoanMapper {
    public static LoanDTO toDto(Loan loan){
        return new LoanDTO(
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
