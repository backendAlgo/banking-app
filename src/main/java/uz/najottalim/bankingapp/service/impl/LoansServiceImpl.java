package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.LoansDTO;
import uz.najottalim.bankingapp.repository.LoansRepository;
import uz.najottalim.bankingapp.service.LoansService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoansRepository loansRepository;

    @Override
    public ResponseEntity<LoansDTO> getLoansById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<LoansDTO>> getAllLoans() {
        return null;
    }

    @Override
    public ResponseEntity<LoansDTO> addLoans(LoansDTO loansDTO) {
        return null;
    }

    @Override
    public ResponseEntity<LoansDTO> updateLoans(LoansDTO loansDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<LoansDTO> deleteLoans(Long id) {
        return null;
    }
}
