package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.Entity.Authority;
import uz.najottalim.bankingapp.Entity.Role;

import java.util.List;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority , Long> {

    List<Authority> findByRole(Role role);
}
