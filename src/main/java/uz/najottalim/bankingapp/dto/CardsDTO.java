package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardsDTO {
    private Long id;
    private Long accountId;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Long cardTypeId;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;

}
