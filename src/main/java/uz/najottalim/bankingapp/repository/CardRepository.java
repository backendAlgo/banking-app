package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.entity.Card;

import java.util.*;

public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findAllByAccountId(Long id);
}
