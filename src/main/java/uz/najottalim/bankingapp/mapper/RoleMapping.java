package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.RoleDto;
import uz.najottalim.bankingapp.model.Role;

import java.util.Collections;

public class RoleMapping {
    public static RoleDto toDto(Role role) {
        return role == null ? null : new RoleDto(
                role.getId(),
                role.getName()
        );
    }

    public static Role toEntity(RoleDto roleDto) {
        return roleDto == null ? null : new Role(
                roleDto.getId(),
                roleDto.getName(),
                Collections.emptyList()
        );
    }
}
