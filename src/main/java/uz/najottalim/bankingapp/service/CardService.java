package uz.najottalim.bankingapp.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.CardDTO;

import java.util.List;

public interface CardService {

    ResponseEntity<List<CardDTO>> getById(Long id);
}
