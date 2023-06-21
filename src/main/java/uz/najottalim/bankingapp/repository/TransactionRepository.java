package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.models.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//    @PreAuthorize("hasRole('ROOT') or hasRole('USER')")
    List<Transaction> findByAccount_IdOrderByTransactionDateDesc(Long userId);
    List<Transaction> findByAccountOrderByTransactionDate(Account account);
}
