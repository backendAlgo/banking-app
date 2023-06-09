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
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate transactionDate;
    String summary;
    Double withdrawal;
    Double deposit;
    Double closingBalance;
    @ManyToOne
    Accounts account;

}
