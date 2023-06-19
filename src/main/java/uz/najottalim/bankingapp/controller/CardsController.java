//package uz.najottalim.bankingapp.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import uz.najottalim.bankingapp.dto.CardsDto;
//import uz.najottalim.bankingapp.dto.CardsDto;
//import uz.najottalim.bankingapp.service.CardsService;
//import uz.najottalim.bankingapp.service.CardsService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("cards")
//@Slf4j
//@RequiredArgsConstructor
//public class CardsController {
//
//    private final CardsService cardService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CardsDto> getCardsById(@PathVariable Long id){
//        return cardService.getCardsById(id);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CardsDto>> getAllCards(@RequestParam Optional<Integer> pageNum,
//                                                     @RequestParam Optional<Integer> pageSize,
//                                                     @RequestParam Optional<String> columnName){
//        return cardService.getAllCards(columnName,pageNum,pageSize);
//    }
//
//    @PostMapping
//    public ResponseEntity<CardsDto> addCards(@RequestBody CardsDto cardDTO){
//        return cardService.addCards(cardDTO);
//    }
//
//    @PutMapping
//    public ResponseEntity<CardsDto> updateCards(@RequestBody CardsDto cardDTO){
//        return cardService.updateCards(cardDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<CardsDto> deleteCards(@PathVariable Long id){
//        return cardService.deleteCards(id);
//    }
//
//}
