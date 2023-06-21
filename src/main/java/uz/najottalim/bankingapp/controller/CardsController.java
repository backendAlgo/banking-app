package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.service.CardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cards")
@Slf4j
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<List<CardDTO>> getCardsById(@PathVariable Long id){
        return cardService.getCardsById(id);
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAllCards(@RequestParam Optional<Integer> pageNum,
                                                     @RequestParam Optional<Integer> pageSize,
                                                     @RequestParam Optional<String> columnName){
        return cardService.getAllCards(columnName,pageNum,pageSize);
    }

    @PostMapping
    public ResponseEntity<CardDTO> addCards(@RequestBody CardDTO cardDTO){
        return cardService.addCards(cardDTO);
    }

    @PutMapping
    public ResponseEntity<CardDTO> updateCards(@RequestBody CardDTO cardDTO){
        return cardService.updateCards(cardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDTO> deleteCards(@PathVariable Long id){
        return cardService.deleteCards(id);
    }

}
