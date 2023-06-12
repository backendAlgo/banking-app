package uz.najottalim.bankingapp.dto.cardDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;
import uz.najottalim.bankingapp.entity.CardType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardDto {
    private Long id;
    private String cardNumber;
    private LocalDate cardExpiredData;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;
    private CardType cardType;
    private AccountDto accountDto;

}
