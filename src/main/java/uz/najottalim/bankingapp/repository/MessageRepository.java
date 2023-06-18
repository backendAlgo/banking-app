package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.Message;


@Repository

public interface MessageRepository extends JpaRepository<Message, Long> {
}
