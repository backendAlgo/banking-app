package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;
    @Column(name = "transaction_date")
    private LocalDate transactionDate;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    @Column(name = "closing_balance")
    private Double closingBalance;

}
