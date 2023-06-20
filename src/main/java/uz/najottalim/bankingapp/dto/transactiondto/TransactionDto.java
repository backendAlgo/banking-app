package uz.najottalim.bankingapp.dto.transactiondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    /*
    public accountNumber: number;
  public customerId: number;
  public transactionDt: Date;
  public transactionSummary: string;
  public transactionType: string;
  public transactionAmt: number;
  public closingBalance: number;
  */
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
}
