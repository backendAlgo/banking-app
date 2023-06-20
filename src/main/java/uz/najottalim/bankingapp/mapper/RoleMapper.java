package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Dto.RoleDTO;
import uz.najottalim.bankingapp.entity.Role;

public class RoleMapper {
    public static Role toEntity(RoleDTO roleDTO){
        return new Role(
                roleDTO.getId(),
                roleDTO.getName()

        );
    }
    public static RoleDTO toDto(Role role) {
        return new RoleDTO(
                role.getId(),
                role.getName()


        );
    }
}
