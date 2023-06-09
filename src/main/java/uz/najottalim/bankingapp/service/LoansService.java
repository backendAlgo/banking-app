package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.LoansDTO;

import java.util.List;

public interface LoansService {
    ResponseEntity<LoansDTO> getLoansById(Long id);

    ResponseEntity<List<LoansDTO>> getAllLoans();

    ResponseEntity<LoansDTO> addLoans(LoansDTO loansDTO);

    ResponseEntity<LoansDTO> updateLoans(LoansDTO loansDTO, Long id);

    ResponseEntity<LoansDTO> deleteLoans(Long id);
}
