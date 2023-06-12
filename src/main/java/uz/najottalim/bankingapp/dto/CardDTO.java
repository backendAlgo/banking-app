package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.models.CardType;

import java.time.LocalDate;


public record CardDTO (
     Long id,
     Account account,
     String cardNumber,
     LocalDate cardExpiredDate,
     CardTypeDTO cardTypeDTO,
     Double totalLimit,
     Double amountUsed,
     Double availableAmt){

}
