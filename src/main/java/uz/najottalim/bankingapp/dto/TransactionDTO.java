package uz.najottalim.bankingapp.dto;

import lombok.*;
import uz.najottalim.bankingapp.models.Account;

import java.time.LocalDate;


public record TransactionDTO (
    Long id,
    Account account,
    LocalDate transactionDate,
    String summary,
    Double withdrawal,
    Double deposit,
    Double closingBalance){
}
