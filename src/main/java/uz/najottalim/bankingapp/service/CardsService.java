package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.CardsDTO;

import java.util.List;

public interface CardsService {
    ResponseEntity<CardsDTO> getCardsById(Long id);

    ResponseEntity<List<CardsDTO>> getAllCards();

    ResponseEntity<CardsDTO> addCards(CardsDTO cardsDTO);

    ResponseEntity<CardsDTO> updateCards(CardsDTO cardsDTO);

    ResponseEntity<CardsDTO> deleteCards(Long id);
}
