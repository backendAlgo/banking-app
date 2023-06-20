package uz.najottalim.bankingapp.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
    @ManyToOne
    @JoinColumn(name = "typeLoansId")
    private LoanType loanType;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Loan(Long customerId, LocalDate startDt, Double totalLoan, Double amountPaid, Double outstandingAmount) {
        this.id=customerId;
        this.startDate=startDt;
        this.totalLoan=totalLoan;
        this.amountPay=amountPaid;
        this.outstandingAmt=outstandingAmount;
    }
}
