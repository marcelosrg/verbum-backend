package com.verbum.api.infraestructure.dtos.Auth;

import java.util.UUID;

public record AuthRequestDto(UUID id, String email, String password) {
}
