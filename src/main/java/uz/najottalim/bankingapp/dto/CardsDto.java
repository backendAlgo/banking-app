package uz.najottalim.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsDto {
    @NotBlank(message = "id can  not be null")
    private Integer id;

    @NotBlank(message = "accountId can  not be null")
    private Integer accountId;

    @NotBlank(message = "cardNumber can  not be null")
    private String cardNumber;

    @NotBlank(message = "cardExpireDate can  not be null")
    private LocalDate cardExpiredDate;

    @NotBlank(message = "cardTypeId can  not be null")
    private Integer cardTypeId;

    @NotBlank(message = "totalLimit can  not be null")
    private Double totalLimit;

    @NotBlank(message = "amountUsed can  not be null")
    private Double amountUsed;

    @NotBlank(message = "availableAmount can  not be null")
    private Double availableAmt;
}
