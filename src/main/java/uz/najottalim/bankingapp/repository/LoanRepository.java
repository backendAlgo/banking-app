package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.Loan;

import java.util.*;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findAllByAccountId(Long id);
}
