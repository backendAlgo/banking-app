package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Entity.Role;
import uz.najottalim.bankingapp.dto.RoleDto;

public class RoleMapper {
    public static Role toEntity(RoleDto roleDTO) {
        return new Role(roleDTO.getId(),
                roleDTO.getName(),
                null,
                null);
    }

    public static RoleDto toDto(Role role) {
        return new RoleDto(role.getId(),
                role.getName());
    }
}
