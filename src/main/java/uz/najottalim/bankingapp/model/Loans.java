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

public class Loans {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate startDate;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;

    @ManyToOne
    private Account account;

    @ManyToOne
    private TypeLoans typeLoans;




//    account_id number,
//    start_date date,
//    type_loans_id number,
//    total_loan real,
//    amount_pay real,
//    outstanding_amt real,
//    primary key (id)





}
