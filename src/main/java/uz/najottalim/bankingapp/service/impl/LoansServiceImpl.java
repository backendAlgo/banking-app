package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.repository.LoanRepository;
import uz.najottalim.bankingapp.service.LoansService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public ResponseEntity<LoanDTO> getLoansById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        return null;
    }

    @Override
    public ResponseEntity<LoanDTO> addLoans(LoanDTO loanDTO) {
        return null;
    }

    @Override
    public ResponseEntity<LoanDTO> updateLoans(LoanDTO loanDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<LoanDTO> deleteLoans(Long id) {
        return null;
    }
}
