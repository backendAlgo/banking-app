package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.LoansDTO;
import uz.najottalim.bankingapp.models.Loans;

@Component
public class LoansMapper {

   public Loans toEntity(LoansDTO loansDTO){
       if(loansDTO == null) return null;
       return new Loans();
   }

   public LoansDTO toDto(Loans loans){
       if(loans == null) return null;
       return new LoansDTO();
   }
}
