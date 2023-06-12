package uz.najottalim.bankingapp.dto.carddto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTypeDto {
    private Long id;
    private String name;
}
