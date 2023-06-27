package uz.najottalim.bankingapp.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "type_loans_id")
    private LoanType loanType;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}
