package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.CardsDTO;
import uz.najottalim.bankingapp.repository.CardsRepository;
import uz.najottalim.bankingapp.service.CardsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {
    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public ResponseEntity<CardsDTO> getCardsById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CardsDTO>> getAllCards() {
        return null;
    }

    @Override
    public ResponseEntity<CardsDTO> addCards(CardsDTO cardsDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CardsDTO> updateCards(CardsDTO cardsDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CardsDTO> deleteCards(Long id) {
        return null;
    }
}
