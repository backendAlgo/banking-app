package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.carddto.CardDto;

import java.util.List;

public interface CardService {
    ResponseEntity<List<CardDto>> getByAccountId(Long id);
}
