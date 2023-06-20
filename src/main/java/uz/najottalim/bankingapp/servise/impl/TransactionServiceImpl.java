package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.transactiondto.TransactionDto;
import uz.najottalim.bankingapp.entity.Transaction;
import uz.najottalim.bankingapp.repository.TransactionRepository;
import uz.najottalim.bankingapp.servise.TransactionService;
import uz.najottalim.bankingapp.servise.mapper.TransactionMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public ResponseEntity<List<TransactionDto>> getByAccountId(Long id) {
        return ResponseEntity.ok(transactionRepository.findAllByAccountIdOrderByTransactionDateDesc(id)
                .stream()
                .map(TransactionMapper::toDto)
                .collect(Collectors.toList()));
    }
}
