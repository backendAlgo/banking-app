package uz.najottalim.bankingapp.dto.accountsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Integer id;
    private String name;
    private List<AuthorityDto> authorities;

    public RoleDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
