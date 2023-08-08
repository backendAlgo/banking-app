package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Entity.CardType;
import uz.najottalim.bankingapp.dto.CardTypeDto;

public class CardTypeMapper {
    public static CardType toEntity(CardType cardTypeDTO){
        if(cardTypeDTO == null) return null;
        return new CardType(
                cardTypeDTO.getId(),
                cardTypeDTO.getName()
        );
    }

    public static CardTypeDto toDto(CardType cardType){
        if(cardType == null) return null;
        return new CardTypeDto(
                cardType.getId(),
                cardType.getName()
        );
    }
}

