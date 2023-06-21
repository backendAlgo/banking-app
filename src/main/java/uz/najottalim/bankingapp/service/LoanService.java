package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.loanDTO.LoanDto;

import java.util.List;

public interface LoanService {
    ResponseEntity<List<LoanDto>> getByAccountId(Long id);

}
