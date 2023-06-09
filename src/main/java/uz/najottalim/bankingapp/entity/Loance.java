package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Loance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer accoountId;
    private LocalDate startDate;
    private Integer typeLoansId;
    private Double totalLoan;
    private Double amountPay;
    private Double outstandingAmt;
}

