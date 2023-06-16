package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.dto.RoleDTO;
import uz.najottalim.bankingapp.model.Role;

public class RoleMapper {
    public static Role toEntity(RoleDTO roleDTO) {
        return new Role(roleDTO.getId(),
            roleDTO.getName(),
                null,
                null);
    }

    public static RoleDTO toDto(Role role) {
        return new RoleDTO(role.getId(),
                role.getName());
    }
}
