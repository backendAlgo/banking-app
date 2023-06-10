package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.models.Transaction;

@Component
@RequiredArgsConstructor
public class TransactionMapper {
    private final AccountTypeMapper accountTypeMapper;
//    public Transaction toEntity(TransactionDTO transactionDTO){
//        if(transactionDTO == null) return null;
//        return new Transaction(
//                transactionDTO.getId(),
//                transactionDTO.getAccountId(),
//                transactionDTO.getTransactionDate(),
//                transactionDTO.getSummary(),
//                transactionDTO.getWithdrawal(),
//                transactionDTO.getDeposit(),
//                transactionDTO.getClosingBalance()
//        );
//    }

    public TransactionDTO toDto(Transaction transaction){
        if(transaction == null) return null;
        return new TransactionDTO();
    }
}
