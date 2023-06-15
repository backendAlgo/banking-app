package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.dto.accountsDTO.AuthorityDto;
import uz.najottalim.bankingapp.entity.Authority;

public class AuthorityMapper {
    public static AuthorityDto toDto(Authority authority){
        return new AuthorityDto(authority.getId(), authority.getName());
    }

    public static Authority toEntity(AuthorityDto authorityDto) {
        return new Authority(authorityDto.getId(), authorityDto.getName());
    }
}