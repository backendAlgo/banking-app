package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.model.CardType;

public interface CardTypeRepository extends JpaRepository<CardType, Long> {
    CardType findByName(String name);
}
