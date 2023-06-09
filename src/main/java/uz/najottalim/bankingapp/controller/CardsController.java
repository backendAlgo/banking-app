package uz.najottalim.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.CardsDTO;
import uz.najottalim.bankingapp.service.CardsService;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @GetMapping("/{id}")
    public ResponseEntity<CardsDTO> getCardsById(@PathVariable Long id){
        return cardsService.getCardsById(id);
    }

    @GetMapping
    public ResponseEntity<List<CardsDTO>> getAllCards(){
        return cardsService.getAllCards();
    }

    @PostMapping
    public ResponseEntity<CardsDTO> addCards(@RequestBody CardsDTO cardsDTO){
        return cardsService.addCards(cardsDTO);
    }

    @PutMapping
    public ResponseEntity<CardsDTO> updateCards(@RequestBody CardsDTO cardsDTO){
        return cardsService.updateCards(cardsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardsDTO> deleteCards(@PathVariable Long id){
        return cardsService.deleteCards(id);
    }

}
