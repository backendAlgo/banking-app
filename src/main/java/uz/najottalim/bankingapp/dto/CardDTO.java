package uz.najottalim.bankingapp.dto;


import java.time.LocalDate;

public record CardDTO(
        Long customerId,
        String cardNumber,
        LocalDate cardExpiredDate,
        String cardType,
        Double totalLimit,
        Double amountUsed,
        Double availableAmount
) {

}
