package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.CardDTO;

import java.util.List;
import java.util.Optional;

public interface CardService {
    ResponseEntity<CardDTO> getCardsById(Long id);

    ResponseEntity<List<CardDTO>> getAllCards(Optional<String> columnName, Optional<Integer> pageNum, Optional<Integer> pageSize);


    ResponseEntity<CardDTO> addCards(CardDTO cardDTO);

    ResponseEntity<CardDTO> updateCards(CardDTO cardDTO);

    ResponseEntity<CardDTO> deleteCards(Long id);

}
