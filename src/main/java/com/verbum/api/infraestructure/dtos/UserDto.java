package com.verbum.api.infraestructure.dtos;

import com.verbum.api.core.enums.Role;

import java.util.UUID;

public record UserDto(
        UUID id,
        String email,
        String password,
        Boolean isActive,
        Role role
) {
}