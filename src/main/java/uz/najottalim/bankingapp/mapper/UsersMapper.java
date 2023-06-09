package uz.najottalim.bankingapp.mapper;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.UsersDTO;

@Component
public class UsersMapper {

    public User toEntity(UsersDTO usersDTO){
        if(usersDTO == null) return null;
        return null;
    }
}
