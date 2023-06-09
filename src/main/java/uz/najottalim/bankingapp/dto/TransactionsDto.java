package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "accountId can  not be null")
    private Integer accountId;

    @NotBlank(message = "transactionDate can  not be null")
    private LocalDate transactionDate;

    @NotBlank(message = "summary can  not be null")
    private String summary;

    @NotBlank(message = "withDrawal can  not be null")
    private Double withDrawal;

    @NotBlank(message = "deposit can  not be null")
    private Double deposit;

    @NotBlank(message = "closingBalance can  not be null")
    private Double closingBalance;
}
