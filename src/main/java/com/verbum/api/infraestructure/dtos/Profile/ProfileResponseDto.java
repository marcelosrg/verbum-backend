package com.verbum.api.infraestructure.dtos.Profile;

import com.verbum.api.core.domain.User;

import java.util.UUID;

public record ProfileResponseDto(UUID id,
                                 String userName,
                                 String biography
                                 ) {
}
