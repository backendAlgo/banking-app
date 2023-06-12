package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.models.Transaction;

@Component
@RequiredArgsConstructor
public class TransactionMapper {
    private final AccountTypeMapper accountTypeMapper;
    public Transaction toEntity(TransactionDTO transactionDTO){
        if(transactionDTO == null) return null;
        return new Transaction(
                transactionDTO.id(),
                transactionDTO.account(),
                transactionDTO.transactionDate(),
                transactionDTO.summary(),
                transactionDTO.withdrawal(),
                transactionDTO.deposit(),
                transactionDTO.closingBalance()
        );
    }

    public TransactionDTO toDto(Transaction transaction){
        if(transaction == null) return null;
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAccount(),
                transaction.getTransactionDate(),
                transaction.getSummary(),
                transaction.getWithdrawal(),
                transaction.getDeposit(),
                transaction.getClosingBalance()
        );
    }
}
