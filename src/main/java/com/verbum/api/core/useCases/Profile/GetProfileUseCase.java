package com.verbum.api.core.useCases.Profile;

import com.verbum.api.core.domain.Profile;

import java.util.UUID;

public interface GetProfileUseCase {

    Profile execute(UUID id);
}
