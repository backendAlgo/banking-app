package uz.najottalim.bankingapp.dto.carddto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.CardType;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;
    private CardTypeDto cardTypeDto;
    private AccountDto accountDto;
}
