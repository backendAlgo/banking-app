package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.CardDTO;

import java.util.List;

public interface CardsService {
    ResponseEntity<CardDTO> getCardsById(Long id);

    ResponseEntity<List<CardDTO>> getAllCards();

    ResponseEntity<CardDTO> addCards(CardDTO cardDTO);

    ResponseEntity<CardDTO> updateCards(CardDTO cardDTO);

    ResponseEntity<CardDTO> deleteCards(Long id);
}
