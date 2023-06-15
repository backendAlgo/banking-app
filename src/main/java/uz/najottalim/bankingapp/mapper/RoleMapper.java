package uz.najottalim.bankingapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.RoleDTO;
import uz.najottalim.bankingapp.models.Role;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    public Role toEntity(RoleDTO roleDTO){
        if(roleDTO == null) return null;
        return new Role(
                roleDTO.id(),
                roleDTO.name(),
                null,
                null,
                null
        );
    }

    public RoleDTO toDto(Role role){
        if(role == null) return null;
        return new RoleDTO(
                role.getId(),
                role.getName()
        );
    }

}
