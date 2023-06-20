package uz.najottalim.bankingapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


@With
public record AccountTypeDto (
    Long id,
    String name){
}
