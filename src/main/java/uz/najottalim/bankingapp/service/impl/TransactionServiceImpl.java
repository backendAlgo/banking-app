package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.repository.TransactionRepository;
import uz.najottalim.bankingapp.service.TransactionService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<TransactionDTO> getTransactionById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDTO> getAllTransaction(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDTO> addTransaction(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDTO> updateTransaction(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDTO> deleteTransaction(Long id) {
        return null;
    }
}
