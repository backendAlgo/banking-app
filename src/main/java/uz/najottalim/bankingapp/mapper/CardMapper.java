package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.models.Card;

@Component
public class CardMapper {

    public Card toEntity(CardDTO cardDTO){
        if(cardDTO == null) return null;
        return new Card();
    }

    public CardDTO toDto(Card card){
        if(card == null) return null;
        return new CardDTO();
    }
}
