package com.verbum.api.core.useCases;

import com.verbum.api.core.domain.User;

import java.util.UUID;

public interface UpdateUserUseCase {
    public User execute(UUID id, User user);
}
