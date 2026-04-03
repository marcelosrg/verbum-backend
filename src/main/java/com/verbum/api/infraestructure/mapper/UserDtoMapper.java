package com.verbum.api.infraestructure.mapper;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.enums.Role;
import com.verbum.api.infraestructure.dtos.AuthRequestDto;
import com.verbum.api.infraestructure.dtos.AuthResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public User toDomain(AuthRequestDto userDto){
        return new User(
                userDto.id(),
                userDto.email(),
                userDto.password(),
               true,
                Role.USER
        );
    }

    public AuthResponseDto toDto (User user){
        return new AuthResponseDto(
                user.email(),
                user.password()
        );
    }

}
