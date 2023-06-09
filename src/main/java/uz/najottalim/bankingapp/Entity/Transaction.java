package uz.najottalim.bankingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate transaction_date;
    private String summary;
    private Double withdrawal;
    private Double deposit;
    private Double closingBalance;

    @ManyToOne
    private Account accountId;
}
