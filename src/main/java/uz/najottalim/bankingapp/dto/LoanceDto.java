package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanceDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "accountId can  not be null")
    private Integer accoountId;

    @NotBlank(message = "startDate can  not be null")
    private LocalDate startDate;

    @NotBlank(message = "LoansTypeId can  not be null")
    private Integer typeLoansId;

    @NotBlank(message = "totalLoan can  not be null")
    private Double totalLoan;

    @NotBlank(message = "amountPay can  not be null")
    private Double amountPay;

    @NotBlank(message = "outstandingAmount can  not be null")
    private Double outstandingAmt;
}
