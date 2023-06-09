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
@Table(name = "Credits")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "type_loans_id")
    private Long typeLoansId;
    @Column(name = "total_loan")
    private Double totalLoan;
    @Column(name = "amount_py")
    private Double amountPy;
    @Column(name = "outstanding_amt")
    private Double outstandingAmt;
}
