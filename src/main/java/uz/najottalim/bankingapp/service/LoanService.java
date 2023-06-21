package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    ResponseEntity<List<LoanDTO>> getById(Long id);
}
