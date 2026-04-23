package com.verbum.api.core.domain;

import java.util.UUID;

public record Profile ( UUID id,
        String username,
        String biography,
        String imageUrl,
        UUID userId){

}
