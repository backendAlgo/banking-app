package uz.najottalim.bankingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;

    @ManyToOne
    private Account account;
}
