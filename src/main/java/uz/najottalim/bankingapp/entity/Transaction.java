package uz.najottalim.bankingapp.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "summary")
    private String summary;

    @Column(name = "withdrawal")
    private Float withdrawal;

    @Column(name = "deposit")
    private Float deposit;

    @Column(name = "closing_balance")
    private Float closingBalance;

}
