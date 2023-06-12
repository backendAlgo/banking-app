package uz.najottalim.bankingapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTypeDTO {
    private Long id;
    private String name;
}
