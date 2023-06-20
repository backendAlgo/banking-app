package uz.najottalim.bankingapp.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
    public class CardDTO {
    private Long customerId;
    private String cardNumber;
    private CardTypeDTO cardTypeDTO;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmount;

}