package com.verbum.api.infraestructure.mapper;

import com.verbum.api.core.domain.User;
import com.verbum.api.infraestructure.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public User toDomain(UserDto userDto){
        return new User(
                userDto.id(),
                userDto.email(),
                userDto.password(),
                userDto.isActive(),
                userDto.role()
        );
    }

    public UserDto toDto (User user){
        return new UserDto(
                user.id(),
                user.email(),
                user.password(),
                user.isActive(),
                user.role()
        );
    }
}
