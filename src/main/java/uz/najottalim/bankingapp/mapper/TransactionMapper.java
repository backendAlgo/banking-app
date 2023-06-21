package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.model.Transaction;

public class TransactionMapper {
    public static Transaction toEntity(TransactionDTO transactionDTO){
        if (transactionDTO == null) return null;
        return new Transaction(
                transactionDTO.getId(),
                AccountMapper.toEntity(transactionDTO.getAccountDTO()),
                transactionDTO.getTransactionDate(),
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
                transaction.getTransactionDate(),
                transaction.getSummary(),
                transaction.getDeposit() != null ? "Deposit" : "Withdrawal",
                transaction.getDeposit() != null ? transaction.getDeposit() : transaction.getWithdrawal(),
                transaction.getClosingBalance(),
                AccountMapper.toDto(transaction.getAccount())
        );
    }
}
