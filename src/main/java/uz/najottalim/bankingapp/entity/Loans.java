package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Integer accountId;
    private LocalDate startDate;
    private Integer typeLoansId;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}
