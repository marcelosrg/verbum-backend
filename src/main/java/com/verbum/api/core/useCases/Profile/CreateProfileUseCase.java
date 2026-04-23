package com.verbum.api.core.useCases.Profile;

import com.verbum.api.core.domain.Profile;

public interface CreateProfileUseCase {
    Profile execute(Profile profile);
}
