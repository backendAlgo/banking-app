package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.models.Loan;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final LoanTypeMapper loanTypeMapper;

   public Loan toEntity(LoanDTO loanDTO){
       if(loanDTO == null) return null;
       return new Loan(
               loanDTO.getId(),
               null,
               loanDTO.getStartDate(),
               loanTypeMapper.toEntity(loanDTO.getLoanTypeDTO()),
               loanDTO.getTotalLoan(),
               loanDTO.getAmountPay(),
               loanDTO.getOutstandingAmt()
       );
   }

   public LoanDTO toDto(Loan loan){
       if(loan == null) return null;
       return new LoanDTO(
               loan.getId(),
               null,
               loan.getStartDate(),
               loanTypeMapper.toDto(loan.getLoanType()),
               loan.getTotalLoan(),
               loan.getAmountPay(),
               loan.getOutstandingAmt()
       );
   }
}
