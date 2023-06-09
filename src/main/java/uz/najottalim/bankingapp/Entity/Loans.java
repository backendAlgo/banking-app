package uz.najottalim.bankingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LoansType typeLoans;


}
