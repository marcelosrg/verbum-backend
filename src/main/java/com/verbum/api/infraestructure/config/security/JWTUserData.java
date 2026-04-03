package com.verbum.api.infraestructure.config.security;

import com.verbum.api.core.enums.Role;
import lombok.Builder;

import java.util.UUID;
@Builder
public record JWTUserData(UUID id, String email, Role role) {
}
