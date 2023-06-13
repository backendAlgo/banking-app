package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.model.Authority;
import uz.najottalim.bankingapp.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findRoleByParentRole(Role role);
<<<<<<< HEAD
}
=======
}
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
