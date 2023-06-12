package uz.najottalim.bankingapp.dto.loandto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTypeDto {
    private Long id;
    private String name;
}
