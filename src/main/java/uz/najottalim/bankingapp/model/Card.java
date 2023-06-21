package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
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
    @JoinColumn(name = "card_type_id")
    private CardType cardType;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;


}
//    account_id number,
//    card_number varchar(20),
//    card_expired_date date,
//    card_type_id number,
//    total_limit real,
//    amount_used real,
//    available_amt real,
