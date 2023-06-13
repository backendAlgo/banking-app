package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.mapper.LoanMapper;
import uz.najottalim.bankingapp.models.Loan;
import uz.najottalim.bankingapp.repository.LoanRepository;
import uz.najottalim.bankingapp.service.LoansService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    public ResponseEntity<LoanDTO> getLoansById(Long id) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        if(loanOptional == null){
            throw new NoSuchElementException("loan not found");
        }
        return ResponseEntity.ok(
                loanMapper.toDto(loanOptional.get())
        );
    }

    @Override
    public ResponseEntity<List<LoanDTO>> getAllLoans(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize) {
        PageRequest pageable = null;
        Sort sort = null;
        if(pageNum.isPresent() && pageSize.isPresent()){
            pageable = PageRequest.of(pageNum.get(), pageSize.get());
        }
        if(columnName.isPresent()){
            sort = Sort.by(columnName.get());
            if(pageable != null){
                pageable = PageRequest.of(pageNum.get(),pageSize.get(),Sort.by(columnName.get()));
            }
        }
        if(pageable != null){
            return ResponseEntity.ok(
                    loanRepository.findAll(pageable)
                            .stream()
                            .map(loanMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        else if(sort != null){
            return ResponseEntity.ok(
                    loanRepository.findAll(sort)
                            .stream()
                            .map(loanMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        return ResponseEntity.ok(
                loanRepository.findAll()
                        .stream()
                        .map(loanMapper::toDto)
                        .collect(Collectors.toList())
        );
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
