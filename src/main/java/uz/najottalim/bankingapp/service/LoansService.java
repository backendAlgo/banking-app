package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.LoanDTO;

import java.util.List;

public interface LoansService {
    ResponseEntity<LoanDTO> getLoansById(Long id);

    ResponseEntity<List<LoanDTO>> getAllLoans();

    ResponseEntity<LoanDTO> addLoans(LoanDTO loanDTO);

    ResponseEntity<LoanDTO> updateLoans(LoanDTO loanDTO, Long id);

    ResponseEntity<LoanDTO> deleteLoans(Long id);
}
