package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
