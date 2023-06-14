package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "/card")
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
    @JoinColumn(name = "card_type_id")
    private CardType cardType;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
