package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "card_expired_date")
    private Date cardExpiredDate;
    private Long cardTypeId;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;
    @ManyToOne
    private CardType cardType;
    @ManyToOne
    private Accounts accounts;

}
