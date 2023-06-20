package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.entity.Transaction;

import java.util.*;
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findAllByAccountIdOrderByTransactionDateDesc(Long accountId);
}
