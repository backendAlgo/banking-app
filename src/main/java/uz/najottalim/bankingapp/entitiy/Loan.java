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
    @Column(name = "type_loans_id ")
    private uz.najottalim.bankingapp.entity.LoanType loanType;

    @ManyToOne
    private uz.najottalim.bankingapp.entity.Account account;


}