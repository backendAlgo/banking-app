package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.mapper.CardMapper;
import uz.najottalim.bankingapp.model.Card;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.service.CardService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardService {
    @Autowired
    private CardRepository cardsRepository;


    @Override
    public ResponseEntity<List<CardDTO>> getById(Long id) {
        List<Card> cards=cardsRepository.findByAccountId(id);
        List<CardDTO> s = cards.stream()
                .map(CardMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(s);
    }
}
