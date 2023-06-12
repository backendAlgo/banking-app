package uz.najottalim.bankingapp.servise.mapper;

import uz.najottalim.bankingapp.dto.accountsdto.RoleDto;
import uz.najottalim.bankingapp.entity.Role;

import java.util.stream.Collectors;

public class RoleMapper {
    public static RoleDto toDto(Role role){
        return new RoleDto(role.getId(), role.getName());

    }

    public static Role toEntity(RoleDto roleDto) {
        return new Role(
                roleDto.getId(),
                roleDto.getName(),
                roleDto.getAuthorities()
                        .stream()
                        .map(AuthorityMapper::toEntity)
                        .collect(Collectors.toList()));
    }
}
