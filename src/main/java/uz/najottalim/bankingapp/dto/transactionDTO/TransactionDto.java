package uz.najottalim.bankingapp.dto.transactionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    @JsonProperty(value = "transactionDt")
    private LocalDate transactionDate;
    @JsonProperty(value = "transactionSummary")
    private String summary;
    private Double transactionAmt;
    private String transactionType;
    private Double closingBalance;
    @JsonProperty(value = "customerId")
    private Long accountId;
    private String accountNumber;

//    private Long id;
//    private LocalDate transactionDate;
//    private String summary;
//    private Double withdrawal;
//    private Double deposit;
//    private Double closingBalance;
//    private AccountDto accountDto;
}
