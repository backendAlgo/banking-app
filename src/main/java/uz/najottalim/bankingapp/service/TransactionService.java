package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.TransactionDTO;

import java.util.Optional;

public interface TransactionService {
    ResponseEntity<TransactionDTO> getTransactionById(Long id);

    ResponseEntity<TransactionDTO> getAllTransaction(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize);

    ResponseEntity<TransactionDTO> addTransaction(TransactionDTO transactionDTO);

    ResponseEntity<TransactionDTO> updateTransaction(TransactionDTO transactionDTO);

    ResponseEntity<TransactionDTO> deleteTransaction(Long id);

}


