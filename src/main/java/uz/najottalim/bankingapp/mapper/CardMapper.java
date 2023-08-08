package uz.najottalim.bankingapp.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.Entity.Card;
import uz.najottalim.bankingapp.Entity.CardType;
import uz.najottalim.bankingapp.dto.CardDto;
import uz.najottalim.bankingapp.exeption.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.repository.CardTypeRepository;

public class CardMapper {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CardTypeRepository cardTypeRepository;

    public Card toEntity(CardDto cardDTO) {
        Account account = accountRepository
                .findById(cardDTO.getCustomerId())
                .orElseThrow();
        CardType cardType = cardTypeRepository.findByName(cardDTO.getCardType());
        return new Card(
                cardDTO.getId(),
                account,
                cardDTO.getCardNumber(),
                cardDTO.getCardExpiredDate(),
                cardType,
                cardDTO.getTotalLimit(),
                cardDTO.getAmountUsed(),
                cardDTO.getAvailableAmount()

        );
    }

    public static CardDto toDto(Card card){
        if(card == null) return null;
        return new CardDto(
                card.getId(),
                card.getAccount().getId(),
                card.getCardNumber(),
                card.getCardExpiredDate(),
                card.getCardType().getName(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmt()

        );
    }
}
