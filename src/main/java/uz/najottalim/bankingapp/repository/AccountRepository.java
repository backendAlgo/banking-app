package uz.najottalim.bankingapp.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.dto.AccountDTOWithRole;
import uz.najottalim.bankingapp.models.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

//    @Query(value = """
//            insert into account  (name, email, mobile_number, account_number, account_type_id, address, role_id)
//             values ('Jude', 'jsutch0@hostgator.com', '5719036786', '9442174263', 2, '9 Memorial Street', '1');
//            """, nativeQuery = true)
//    AccountDTOWithRole insert();
}
