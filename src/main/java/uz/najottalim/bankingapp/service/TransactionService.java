package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.TransactionDTO;

public interface TransactionService {
    ResponseEntity<TransactionDTO> getTransactionById(Long id);

    ResponseEntity<TransactionDTO> getAllTransaction();

    ResponseEntity<TransactionDTO> addTransaction(TransactionDTO transactionDTO);

    ResponseEntity<TransactionDTO> updateTransaction(TransactionDTO transactionDTO);

    ResponseEntity<TransactionDTO> deleteTransaction(Long id);
}


