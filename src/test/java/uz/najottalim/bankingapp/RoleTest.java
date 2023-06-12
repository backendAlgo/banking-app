package uz.najottalim.bankingapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.najottalim.bankingapp.model.Role;
import uz.najottalim.bankingapp.repository.RoleRepository;

@SpringBootTest
@Slf4j
public class RoleTest {
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void test() {
        Role role = roleRepository.findById(21L).get();
        log.info("Role: {}", roleRepository.findRoleByParentRole(role));
    }
}
