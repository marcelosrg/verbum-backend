package com.verbum.api.infraestructure.dtos.Profile;

import com.verbum.api.core.domain.User;

import java.util.UUID;

public record ProfileRequestDto(UUID id,
                                String username,
                                String biography,
                                String imageUrl,
                                UUID userId) {
}
