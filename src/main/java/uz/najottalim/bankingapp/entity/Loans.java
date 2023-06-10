package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    private LocalDate startDate;
    @ManyToOne
    @Column(name = "type_loans_id")
    private LoansType typeLoansId;
    private Double totalLoan;
    private Double amountPay;
    @ManyToOne
    private Accounts accounts;

}
