package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expired_date")
    private LocalDate cardExpiredDate;

    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @Column(name = "total_limit")
    private Double totalLimit;

    @Column(name = "amount_used")
    private Double amountUsed;

    @Column(name = "available_amt")
    private Double availableAmt;
}
