package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.CardTypeDTO;
import uz.najottalim.bankingapp.models.CardType;

@Component
@RequiredArgsConstructor
public class CardTypeMapper {
    public CardType toEntity(CardTypeDTO cardTypeDTO){
        if(cardTypeDTO == null) return null;
        return new CardType(
                cardTypeDTO.id(),
                cardTypeDTO.name()
        );
    }

    public CardTypeDTO toDto(CardType cardType){
        if(cardType == null) return null;
        return new CardTypeDTO(
                cardType.getId(),
                cardType.getName()
        );
    }
}
