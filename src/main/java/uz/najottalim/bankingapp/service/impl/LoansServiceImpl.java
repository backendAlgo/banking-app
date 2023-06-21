package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.mapper.LoanMapper;
import uz.najottalim.bankingapp.model.Loan;
import uz.najottalim.bankingapp.repository.LoanRepository;
import uz.najottalim.bankingapp.service.LoanService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoanService {

    private final LoanRepository loanRepository;


    @Override
    public ResponseEntity<List<LoanDTO>> getById(Long id) {
        List<Loan> loans=loanRepository.findByAccountId(id);
        List<LoanDTO> loanDTOS = loans.stream()
                .map(LoanMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(loanDTOS);
    }
}
