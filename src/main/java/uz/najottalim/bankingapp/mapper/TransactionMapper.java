package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.TransactionDTO;
import uz.najottalim.bankingapp.entity.Transaction;

@RequiredArgsConstructor
public class TransactionMapper {

    public static Transaction toEntity(TransactionDTO transactionDTO) {
        if (transactionDTO == null) return null;
        return new Transaction(
                transactionDTO.getCustomerId(),
                transactionDTO.getTransactionDt(),
                transactionDTO.getTransactionSummary(),
                transactionDTO.getTransactionType().equals("Withdrawal") ? transactionDTO.getTransactionAmt() : 0,
                transactionDTO.getTransactionType().equals("Deposit") ? transactionDTO.getTransactionAmt() : 0,
                transactionDTO.getClosingBalance()
                );
    }

    public static TransactionDTO toDto(Transaction transaction) {
        if (transaction == null) return null;
        return new TransactionDTO(
                transaction.getId(),
                AccountMapper.toDto(transaction.getAccount()),
                transaction.getTransactionDate(),
                transaction.getSummary(),
                transaction.getDeposit() != null ? "Deposit" : "Withdrawal",
                transaction.getDeposit() != null ? transaction.getDeposit() : transaction.getWithdrawal(),
                transaction.getClosingBalance()
        );
    }
}
