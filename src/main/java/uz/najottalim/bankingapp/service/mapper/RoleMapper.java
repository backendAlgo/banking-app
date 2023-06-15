package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.dto.accountsDTO.RoleDto;
import uz.najottalim.bankingapp.entity.Role;

import java.util.stream.Collectors;

public class RoleMapper {
    public static RoleDto toDto(Role role){
        return new RoleDto(role.getId(), role.getName());
    }
    public static RoleDto toDtoWithAuthorities(Role role){
        return new RoleDto(
                role.getId(),
                role.getName(),
                role.getAuthorities()
                        .stream()
                        .map(AuthorityMapper::toDto)
                        .collect(Collectors.toList())
        );

    }

    public static Role toEntity(RoleDto roleDto) {
        return new Role(
                roleDto.getId(),
                roleDto.getName(),
                roleDto.getAuthorityDtos()
                        .stream()
                        .map(AuthorityMapper::toEntity)
                        .collect(Collectors.toList()));
    }
}
