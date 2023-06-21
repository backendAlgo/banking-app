package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.transactionDTO.TransactionDto;

import java.util.*;
public interface TransactionService {
    ResponseEntity<List<TransactionDto>> getByAccountId(Long id);
}
