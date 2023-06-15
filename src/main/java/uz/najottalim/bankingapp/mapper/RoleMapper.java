package uz.najottalim.bankingapp.mapper;

import uz.najottalim.bankingapp.Entity.Role;
import uz.najottalim.bankingapp.dto.RoleDto;

public class RoleMapper {
    public static RoleDto toDto(Role role){
        return new RoleDto(
                role.getId(),
                role.getName()
        );
    }
}
