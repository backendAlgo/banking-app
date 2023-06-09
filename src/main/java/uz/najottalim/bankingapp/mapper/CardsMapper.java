package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.CardsDTO;
import uz.najottalim.bankingapp.models.Cards;

@Component
public class CardsMapper {

    public Cards toEntity(CardsDTO cardsDTO){
        if(cardsDTO == null) return null;
        return new Cards();
    }

    public CardsDTO toDto(Cards cards){
        if(cards == null) return null;
        return new CardsDTO();
    }
}
