package uz.najottalim.bankingapp.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.models.Card;
import uz.najottalim.bankingapp.models.CardType;

@Component
@RequiredArgsConstructor
public class CardMapper {
    public final CardTypeMapper cardTypeMapper;

    public final AccountMapper accountMapper;

    public Card toEntity(CardDTO cardDTO) {
        if (cardDTO == null) return null;
        return new Card(
                cardDTO.customerId(),
                null,
                cardDTO.cardNumber(),
                cardDTO.cardExpiredDate(),
                new CardType(cardDTO.cardType()),
                cardDTO.totalLimit(),
                cardDTO.amountUsed(),
                cardDTO.availableAmount()
        );
    }

    public CardDTO toDto(Card card){
        if(card == null) return null;
        return new CardDTO(
                card.getId(),
                card.getCardNumber(),
                card.getCardExpiredDate(),
                card.getCardType().getName(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmt()

        );
    }
}
