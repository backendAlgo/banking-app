package uz.najottalim.bankingapp.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoansDTO {
    private Long id;
    private Long accountId;
    private LocalDate startDate;
    private Long typeLoansId;
    private Double totalLoan;
    private Double amountPy;
    private Double outstandingAmt;
}
