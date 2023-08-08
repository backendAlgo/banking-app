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
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;

}

