package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.service.CardsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public ResponseEntity<CardDTO> getCardsById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CardDTO>> getAllCards() {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> addCards(CardDTO cardDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> updateCards(CardDTO cardDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> deleteCards(Long id) {
        return null;
    }
}
