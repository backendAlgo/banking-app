package uz.najottalim.bankingapp.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.models.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}