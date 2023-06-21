package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.service.CardService;

import java.util.List;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;
    @GetMapping("{id}")
    public ResponseEntity<List<CardDTO>> getById(@PathVariable Long id){
        return cardService.getById(id);
    }
}
