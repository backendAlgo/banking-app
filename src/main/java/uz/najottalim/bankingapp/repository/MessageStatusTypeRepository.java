package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.MessagesStatusType;

@Repository
public interface MessageStatusTypeRepository  extends JpaRepository<MessagesStatusType,Long> {
}
