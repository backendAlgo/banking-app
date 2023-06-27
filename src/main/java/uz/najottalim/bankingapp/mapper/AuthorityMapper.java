package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.AuthorityDTO;
import uz.najottalim.bankingapp.models.Authority;
@Component
@RequiredArgsConstructor
public class AuthorityMapper {
    public Authority toEntity(AuthorityDTO authorityDTO){
        if(authorityDTO == null) return null;
        return new Authority(
                authorityDTO.id(),
                authorityDTO.name(),
                null
        );
    }

    public AuthorityDTO toDto(Authority authority){
        if(authority == null) return null;
        return new AuthorityDTO(
                authority.getId(),
                authority.getName()
        );
    }
}
