package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.CardTypeDTO;
import uz.najottalim.bankingapp.model.CardType;

public class CardTypeMapper {

    public static CardType toEntity(CardTypeDTO cardTypeDTO){
        if(cardTypeDTO == null) return null;
        return new CardType(
                cardTypeDTO.getId(),
                cardTypeDTO.getName()
        );
    }

    public static CardTypeDTO toDto(CardType cardType){
        if(cardType == null) return null;
        return new CardTypeDTO(
                cardType.getId(),
                cardType.getName()
        );
    }
}
