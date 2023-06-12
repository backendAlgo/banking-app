package uz.najottalim.bankingapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
//    @JoinColumn(name = "card_type_id")
    private CardType cardType;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;



}
