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

public class Transactions {
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



//    id number generated always as identity,
//    account_id number,
//    transaction_date date,
//    summary varchar(255),
//    withdrawal real,
//    deposit real,
//    closing_balance real,
//    primary key (id)

}


