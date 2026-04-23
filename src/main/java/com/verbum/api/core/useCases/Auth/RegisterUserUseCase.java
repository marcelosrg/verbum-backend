package com.verbum.api.core.useCases.Auth;

import com.verbum.api.core.domain.User;

public interface RegisterUserUseCase {
    User execute(User user);
}
