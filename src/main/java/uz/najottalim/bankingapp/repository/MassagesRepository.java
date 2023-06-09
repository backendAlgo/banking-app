package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Messages;

@Repository
public interface MassagesRepository extends JpaRepository<Messages, Long> {
}
