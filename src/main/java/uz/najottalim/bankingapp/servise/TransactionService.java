package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.transactiondto.TransactionDto;

import java.util.List;

public interface TransactionService {
    ResponseEntity<List<TransactionDto>> getByAccountId(Long id);
}
