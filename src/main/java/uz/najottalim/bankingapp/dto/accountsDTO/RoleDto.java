package uz.najottalim.bankingapp.dto.accountsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleDto {
    private Long id;
    private String name;
    private List<AuthorityDto> authorityDtos;

    public RoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
