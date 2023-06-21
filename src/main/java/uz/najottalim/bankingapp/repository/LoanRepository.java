package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Loan;
import uz.najottalim.bankingapp.model.Transaction;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByAccountId(Long id);

}
