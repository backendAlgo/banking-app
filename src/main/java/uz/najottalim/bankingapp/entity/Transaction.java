package uz.najottalim.bankingapp.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate transactionDate;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    private Double closingBalance;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction(Long customerId, LocalDate transactionDt, String transactionSummary,
                       double withdrawal, double deposit, Double closingBalance) {
        this.id=customerId;
        this.transactionDate=transactionDt;
        this.summary=transactionSummary;
        this.withdrawal=withdrawal;
        this.deposit=deposit;
        this.closingBalance=closingBalance;
    }
}
