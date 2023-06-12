package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "type_loans_id")
    private LoanType loanType;

    @Column(name = "total_loan")
    private Double totalLoan;

    @Column(name = "amount_pay")
    private Double amountPay;

    @Column(name = "outstanding_amt")
    private Double outstandingAmt;
}
