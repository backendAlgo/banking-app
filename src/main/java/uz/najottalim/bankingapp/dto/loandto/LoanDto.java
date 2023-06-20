package uz.najottalim.bankingapp.dto.loandto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    /**
     * public loanNumber: number;
     *   public customerId: number;
     *   public startDt: Date;
     *   public loanType: string;
     *   public totalLoan: number;
     *   public amountPaid: number;
     *   public outstandingAmount: number;
     * **/
    @JsonProperty(value = "loanNumber")
    private Long id;
    @JsonProperty(value = "startDt")
    private LocalDate startDate;
    private Double totalLoan;
    @JsonProperty(value = "amountPaid")
    private Double amountPay;
    @JsonProperty(value = "outstandingAmount")
    private Double outstandingAmt;
    private String loanType;
    @JsonProperty(value = "customerId")
    private Long accountId;
}
