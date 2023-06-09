package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {
}
