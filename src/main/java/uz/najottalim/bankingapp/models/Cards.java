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
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_expired_date")
    private LocalDate cardExpiredDate;
    @Column(name = "card_type_id")
    private Long cardTypeId;
    @Column(name = "total_limit")
    private Double totalLimit;
    @Column(name = "amount_used")
    private Double amountUsed;
    @Column(name = "available_amt")
    private Double availableAmt;


}
