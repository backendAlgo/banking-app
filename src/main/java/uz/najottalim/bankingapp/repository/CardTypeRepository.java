package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.Entity.CardType;

public interface CardTypeRepository extends JpaRepository<CardType,Long> {
    CardType findByName(String cardType);
}
