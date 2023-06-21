package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.Dto.CardDTO;
import uz.najottalim.bankingapp.entity.Cards;
public class CardMapper {

    public Cards toEntity(CardDTO cardDTO) {
        if (cardDTO == null) return null;
        return new Cards(
                cardDTO.getCustomerId(),
                cardDTO.getCardNumber(),
                cardDTO.getTotalLimit(),
                cardDTO.getAmountUsed(),
                cardDTO.getAvailableAmount()
        );
    }

    public CardDTO toDto(Cards card){
        if(card == null) return null;
        return new CardDTO(
                card.getId(),
                card.getAccount().getId(),
                card.getCardNumber(),
                card.getCardType().getName(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmt()

        );
    }
}
