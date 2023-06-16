package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.model.Authority;
import uz.najottalim.bankingapp.model.Role;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    //List<Authority> findByRoles(Role role);
    List<Authority> findByRole(Role role);
}
