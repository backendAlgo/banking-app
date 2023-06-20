package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.carddto.CardDto;
import uz.najottalim.bankingapp.entity.Card;

public class CardMapper {

    public static CardDto cardDto(Card card){
        return new CardDto(
                card.getId(),
                hireCardNumber(card.getCardNumber()),
                card.getCardExpiredDate(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmt(),
                card.getCardType().getName(),
                card.getAccount().getId()
        );
    }

    private static String hireCardNumber(String cardNumber){
        return cardNumber.substring(0,4)+"********"+cardNumber.substring(12);
    }
}
