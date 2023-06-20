package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.loandto.LoanDto;
import uz.najottalim.bankingapp.entity.Loan;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.LoanRepository;
import uz.najottalim.bankingapp.servise.LoanService;
import uz.najottalim.bankingapp.servise.mapper.AccountMapper;
import uz.najottalim.bankingapp.servise.mapper.LoanMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    @Override
    public ResponseEntity<List<LoanDto>> geByAccountId(Long id) {
        List<Loan> loans = loanRepository.findAllByAccountId(id);

        return ResponseEntity.ok(loans.stream().map(LoanMapper::toDto).collect(Collectors.toList()));
    }
}
