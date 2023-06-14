package uz.najottalim.bankingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.Authority;
import uz.najottalim.bankingapp.entity.Role;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    List<Authority> findByRoles(Role role);
}
