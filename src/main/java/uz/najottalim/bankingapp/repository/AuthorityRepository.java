package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Authority;
import uz.najottalim.bankingapp.model.Role;


import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    List<Authority> findByRole(Role role);
}
