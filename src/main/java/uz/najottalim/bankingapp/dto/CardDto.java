package uz.najottalim.bankingapp.dto;
import java.util.Date;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CardDto {
//    @NotNull(message = "Card Number can not be blank")
//    private String cardNumber;
//    @NotNull(message = "Password can not be blank")
//    private String password;
//    @NotNull(message = "Created Date can not be blank")
//    private LocalDate createdAt;
//    @NotNull(message = "Expiry Date can not be blank")
//    private LocalDate expiryDate;
//    @NotNull(message = "Total Limit can not be blank")
//    private Float totalLimit;
//    @NotNull(message = "Used Amount can not be blank")
//    private Float amountUsed;
//    @NotNull(message = "Available Amount can not be blank")
//    private Float availableAmount;
private Long id;
    private Long accountId;
    private String cardNumber;
    private Date cardExpiredDate;
    private Long cardTypeId;
    private Float totalLimit;
    private Float amountUsed;
    private Float availableAmt;

}
