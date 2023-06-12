package uz.najottalim.bankingapp.service.mapper;

import uz.najottalim.bankingapp.dto.accountsDTO.RoleDto;
import uz.najottalim.bankingapp.entity.Role;

public class RoleMapper {
    public static RoleDto toDto(Role role){
        return new RoleDto(role.getId(), role.getName());
    }
}
