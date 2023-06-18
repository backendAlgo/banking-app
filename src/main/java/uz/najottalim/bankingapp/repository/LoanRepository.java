package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.Loan;


@Repository

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
