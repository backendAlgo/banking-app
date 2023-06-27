package uz.najottalim.bankingapp.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.mapper.CardMapper;
import uz.najottalim.bankingapp.models.Card;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.service.CardService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public ResponseEntity<List<CardDTO>> getCardsById(Long id) {
        List<Card> cards=cardRepository.findByAccountId(id);
        List<CardDTO> s = cards.stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(s);
    }

    @Override
    public ResponseEntity<List<CardDTO>> getAllCards(Optional<String> columnName,
                                                     Optional<Integer> pageNum,
                                                     Optional<Integer> pageSize) {
        PageRequest pageabl = null;
        Sort sort = null;
        if(pageNum.isPresent() && pageSize.isPresent()){
            pageabl = PageRequest.of(pageNum.get(), pageSize.get());
        }
        if(columnName.isPresent()){
            sort = Sort.by(String.valueOf(columnName));
            if(pageabl != null){
                pageabl =  PageRequest.of(pageNum.get(),pageSize.get(),Sort.by(columnName.get()));
            }
        }

        if(pageabl != null){
            return ResponseEntity.ok(
                    cardRepository.findAll(pageabl).stream()
                            .map(cardMapper::toDto)
                            .collect(Collectors.toList())
            );
        }else if(sort != null){
            return ResponseEntity.ok(
                    cardRepository.findAll(sort).stream()
                            .map(cardMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        return ResponseEntity.ok(
                cardRepository.findAll()
                        .stream()
                        .map(cardMapper::toDto)
                        .collect(Collectors.toList())
        );
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
