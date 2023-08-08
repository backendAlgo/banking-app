package uz.najottalim.bankingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loans")
@Data
public class Loan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "type_loans_id")
    private LoanType loanType;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;

    @ManyToOne
    private Account account;

}
