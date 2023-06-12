package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.models.Card;

@Component
@RequiredArgsConstructor
public class CardMapper {

    public final CardTypeMapper cardTypeMapper;

    public final AccountMapper accountMapper;
    public Card toEntity(CardDTO cardDTO){
        if(cardDTO == null) return null;
        return new Card(
                cardDTO.getId(),
                null,
                cardDTO.getCardNumber(),
                cardDTO.getCardExpiredDate(),
                cardTypeMapper.toEntity(cardDTO.getCardTypeDTO()),
                cardDTO.getTotalLimit(),
                cardDTO.getAmountUsed(),
                cardDTO.getAvailableAmt()
        );
    }

    public CardDTO toDto(Card card){
        if(card == null) return null;
        return new CardDTO(
                card.getId(),
                null
                ,
                card.getCardNumber(),
                card.getCardExpiredDate(),
                cardTypeMapper.toDto(card.getCardType()),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmt()
        );
    }
}
