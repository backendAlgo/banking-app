package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.models.Loan;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final LoanTypeMapper loanTypeMapper;
    private final AccountMapper accountMapper;

   public Loan toEntity(LoanDTO loanDTO){
       if(loanDTO == null) return null;
       return new Loan(
               loanDTO.id(),
               loanDTO.account(),
               loanDTO.startDate(),
               loanTypeMapper.toEntity(loanDTO.loanTypeDTO()),
               loanDTO.totalLoan(),
               loanDTO.amountPay(),
               loanDTO.outstandingAmt()
       );
   }

   public LoanDTO toDto(Loan loan){
       if(loan == null) return null;
       return new LoanDTO(
               loan.getId(),
               loan.getAccount(),
               loan.getStartDate(),
               loanTypeMapper.toDto(loan.getLoanType()),
               loan.getTotalLoan(),
               loan.getAmountPay(),
               loan.getOutstandingAmt()
       );
   }
}
