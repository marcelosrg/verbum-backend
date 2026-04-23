package com.verbum.api.core.domain;

import java.util.UUID;

public record Profile ( UUID id,
        String userName,
        String biography,
        UUID userId){

}
