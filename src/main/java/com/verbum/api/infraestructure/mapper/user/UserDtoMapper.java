package com.verbum.api.infraestructure.mapper.user;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.enums.Role;
import com.verbum.api.infraestructure.dtos.Auth.AuthRequestDto;
import com.verbum.api.infraestructure.dtos.Auth.AuthResponseDto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public User toDomain(AuthRequestDto userDto) {
        return new User(
                userDto.id(),
                userDto.email(),
                userDto.password(),
                true,
                Role.USER,
                List.of());
    }

    public AuthResponseDto toDto(User user) {
        return new AuthResponseDto(
                user.email(),
                user.password());
    }

}
