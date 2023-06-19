package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer accountId;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Integer cardTypeId;
    private Double totalLimit;
    private Double amountUsed;
    private Double availableAmt;

}
