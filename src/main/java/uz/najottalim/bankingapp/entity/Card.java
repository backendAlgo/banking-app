package uz.najottalim.bankingapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expired_date")
    private Date cardExpiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @Column(name = "total_limit")
    private Float totalLimit;

    @Column(name = "amount_used")
    private Float amountUsed;

    @Column(name = "available_amt")
    private Float availableAmt;
}
