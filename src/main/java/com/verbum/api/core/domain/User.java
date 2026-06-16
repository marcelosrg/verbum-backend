package com.verbum.api.core.domain;

import com.verbum.api.core.enums.Role;

import java.util.List;
import java.util.UUID;

public record User(
        UUID id,
        String email,
        String password,
        boolean isActive,
        Role role,
        List<Posts> posts
) {
    public User withPassword(String newPassword) {
        return new User(id, email, newPassword, isActive, role, posts);
    }

    public boolean isActiveUser() {
        return isActive;
    }
}
