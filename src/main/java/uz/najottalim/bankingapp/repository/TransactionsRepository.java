package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Transactions;

@Repository
public interface TransactionsRepository  extends JpaRepository<Transactions, Long> {
}
