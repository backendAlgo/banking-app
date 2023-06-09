package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;
    @ManyToOne
    private CardType cardType;
    @ManyToOne
    private Accounts account;

}
