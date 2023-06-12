package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
