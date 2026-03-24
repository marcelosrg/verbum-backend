package com.verbum.api.core.domain;

import com.verbum.api.core.enums.Role;

import java.util.UUID;

public record User(
        UUID id,
        String email,
        String password,
        Boolean isActive,
        Role role
) {
}
