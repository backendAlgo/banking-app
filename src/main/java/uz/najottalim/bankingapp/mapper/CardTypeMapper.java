package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.CardTypeDTO;
import uz.najottalim.bankingapp.entity.CardType;
@Component
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
