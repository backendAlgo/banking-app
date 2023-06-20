package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.carddto.CardDto;
import uz.najottalim.bankingapp.servise.CardService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    @GetMapping("/{id}")
    public ResponseEntity<List<CardDto>> getByAccountId(@PathVariable Long id){
        return cardService.getByAccountId(id);
    }
}
