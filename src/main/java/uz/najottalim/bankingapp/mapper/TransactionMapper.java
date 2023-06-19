package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.models.Transaction;

@Component
@RequiredArgsConstructor
public class TransactionMapper {
    private final AccountTypeMapper accountTypeMapper;
    private final AccountMapper accountMapper;

    public Transaction toEntity(TransactionDTO transactionDTO) {
        if (transactionDTO == null) return null;
        return new Transaction(
                transactionDTO.id(),
                accountMapper.toEntity(transactionDTO.account()),
                transactionDTO.transactionDate(),
                transactionDTO.summary(),
                transactionDTO.transactionType().equals("Withdrawal") ? transactionDTO.transactionAmt() : 0,
                transactionDTO.transactionType().equals("Deposit") ? transactionDTO.transactionAmt() : 0,
                transactionDTO.closingBalance()
        );
    }

    public TransactionDTO toDto(Transaction transaction) {
        if (transaction == null) return null;
        return new TransactionDTO(
                transaction.getId(),
                accountMapper.toDto(transaction.getAccount()),
                transaction.getTransactionDate(),
                transaction.getSummary(),
                transaction.getDeposit() != null ? "Deposit" : "Withdrawal",
                transaction.getDeposit() != null ? transaction.getDeposit() : transaction.getWithdrawal(),
                transaction.getClosingBalance()
        );
    }
}
