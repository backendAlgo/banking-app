package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.LoanDTO;

import java.util.List;
import java.util.Optional;

public interface LoansService {
    ResponseEntity<LoanDTO> getLoansById(Long id);

    ResponseEntity<List<LoanDTO>> getAllLoans(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize);

    ResponseEntity<LoanDTO> addLoans(LoanDTO loanDTO);

    ResponseEntity<LoanDTO> updateLoans(LoanDTO loanDTO, Long id);

    ResponseEntity<LoanDTO> deleteLoans(Long id);
}
