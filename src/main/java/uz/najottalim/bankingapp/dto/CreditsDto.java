package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreditsDto {
    @NotNull(message = "startDate can not null")
    private LocalDate startDate;
    @NotNull(message = "Type can not be a null")
    private String type;
    @NotNull(message = "Total Loan can not be a null")
    private Float totalLoan;
    @NotNull(message = "Amount Paid can not be a null")
    private Float amountPaid;
    @NotNull(message = "Outstanding Amount can not be a null")
    private Float outstandingAmount;
}
