package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.models.Transaction;

@Component
public class TransactionsMapper {
    public Transaction toEntity(TransactionDTO transactionDTO){
        if(transactionDTO == null) return null;
        return new Transaction();
    }

    public TransactionDTO toDto(Transaction transaction){
        if(transaction == null) return null;
        return new TransactionDTO();
    }
}
