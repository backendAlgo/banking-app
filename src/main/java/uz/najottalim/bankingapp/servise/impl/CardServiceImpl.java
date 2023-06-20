package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.carddto.CardDto;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.servise.CardService;
import uz.najottalim.bankingapp.servise.mapper.CardMapper;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    @Override
    public ResponseEntity<List<CardDto>> getByAccountId(Long id) {
        return ResponseEntity.ok(
                cardRepository.findAllByAccountId(id)
                        .stream()
                        .map(CardMapper::cardDto)
                        .toList()
                );
    }
}
