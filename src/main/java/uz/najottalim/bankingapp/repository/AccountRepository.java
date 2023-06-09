package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
