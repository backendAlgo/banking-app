package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.models.Loan;

@Component
public class LoanMapper {

   public Loan toEntity(LoanDTO loanDTO){
       if(loanDTO == null) return null;
       return new Loan();
   }

   public LoanDTO toDto(Loan loan){
       if(loan == null) return null;
       return new LoanDTO();
   }
}
