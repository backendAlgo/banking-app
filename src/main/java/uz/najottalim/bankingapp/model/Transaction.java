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
@Table(name = "transactions")
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
    @JoinColumn(name="account_id")
    private Account account;



//    id number generated always as identity,
//    account_id number,
//    transaction_date date,
//    summary varchar(255),
//    withdrawal real,
//    deposit real,
//    closing_balance real,
//    primary key (id)

}

<<<<<<< HEAD
=======

>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
