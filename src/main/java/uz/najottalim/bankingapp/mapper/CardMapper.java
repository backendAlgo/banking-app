package uz.najottalim.bankingapp.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import uz.najottalim.bankingapp.dto.CardDTO;
import uz.najottalim.bankingapp.exceptions.NoResourceFoundException;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.model.Card;
import uz.najottalim.bankingapp.model.CardType;
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

    public Card toEntity(CardDTO cardDTO) {
        Account account = accountRepository
                .findById(cardDTO.getCustomerId())
                .orElseThrow(()->new NoResourceFoundException("No account found"));
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

    public static CardDTO toDto(Card card){
        if(card == null) return null;
        return new CardDTO(
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
