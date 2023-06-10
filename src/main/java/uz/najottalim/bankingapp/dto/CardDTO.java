package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardDTO {
    private Long id;
    private Long accountId;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private CardTypeDTO cardTypeDTO;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;

}
