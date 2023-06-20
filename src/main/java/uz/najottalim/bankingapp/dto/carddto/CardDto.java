package uz.najottalim.bankingapp.dto.carddto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.CardType;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    /*
      public cardNumber: string;
  public customerId: number;
  public cardType: string;
  public totalLimit: number;
  public amountUsed: number;
  public availableAmount: number;
     */
    private Long id;
    private String cardNumber;
    private LocalDate cardExpiredDate;
    private Double totalLimit;
    private Double amountUsed;
    @JsonProperty(value = "availableAmount")
    private Double availableAmt;
    private String cardType;
    @JsonProperty(value = "customerId")
    private Long accountId;
}
