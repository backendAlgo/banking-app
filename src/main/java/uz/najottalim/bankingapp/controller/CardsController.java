package uz.najottalim.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.service.CardsService;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCardsById(@PathVariable Long id){
        return cardsService.getCardsById(id);
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAllCards(){
        return cardsService.getAllCards();
    }

    @PostMapping
    public ResponseEntity<CardDTO> addCards(@RequestBody CardDTO cardDTO){
        return cardsService.addCards(cardDTO);
    }

    @PutMapping
    public ResponseEntity<CardDTO> updateCards(@RequestBody CardDTO cardDTO){
        return cardsService.updateCards(cardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDTO> deleteCards(@PathVariable Long id){
        return cardsService.deleteCards(id);
    }

}
