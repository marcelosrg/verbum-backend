package com.verbum.api.core.domain;

import com.verbum.api.core.enums.Role;

import java.util.UUID;

public record User(
        UUID id,
        String email,
        String password,
        boolean isActive,
        Role role
) {
    public User withPassword(String newPassword) {
        return new User(id, email, newPassword, isActive, role);
    }

    public boolean isActiveUser() {
        return isActive;
    }
}
