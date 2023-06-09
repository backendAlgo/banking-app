package uz.najottalim.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private AccountDto accountDto;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private CardTypeDto cardTypeDto;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;
}
