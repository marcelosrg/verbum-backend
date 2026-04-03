package com.verbum.api.infraestructure.dtos;

import java.util.UUID;

public record AuthRequestDto(UUID id, String email, String password) {
}
