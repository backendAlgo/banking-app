package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.cardDTO.CardDto;

import java.util.List;

public interface CardService {
    ResponseEntity<List<CardDto>> getByAccountId(Long id);
}
