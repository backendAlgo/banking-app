package uz.najottalim.bankingapp.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.najottalim.bankingapp.model.Account;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    private Long id;
    private Long customerId ;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private String cardType;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmount;
}
