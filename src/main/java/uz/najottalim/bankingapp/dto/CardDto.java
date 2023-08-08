package uz.najottalim.bankingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardDto {
    private Long id;
    private Long customerId ;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private String cardType;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmount;
}
