package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.transactiondto.TransactionDto;
import uz.najottalim.bankingapp.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto toDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getTransactionDate(),
                transaction.getSummary(),
                transaction.getTransactionAmt(),
                transaction.getTransactionType().getName(),
                transaction.getClosingBalance(),
                transaction.getAccount().getId(),
                transaction.getAccount().getAccountNumber()
        );
    }
}
